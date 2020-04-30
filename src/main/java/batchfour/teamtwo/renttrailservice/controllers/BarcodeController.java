package batchfour.teamtwo.renttrailservice.controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import batchfour.teamtwo.renttrailservice.entities.Item;
import batchfour.teamtwo.renttrailservice.entities.Rent;
import batchfour.teamtwo.renttrailservice.entities.User;
import batchfour.teamtwo.renttrailservice.models.RentModel;
import batchfour.teamtwo.renttrailservice.models.RentRequest;
import batchfour.teamtwo.renttrailservice.services.ItemService;
import batchfour.teamtwo.renttrailservice.services.RentService;
import batchfour.teamtwo.renttrailservice.services.UserService;

@RestController
@RequestMapping("/barcodes")
public class BarcodeController {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @Autowired
    private RentService rentService;

    @PostMapping("/createqr")
    public String createNewAccount(@RequestBody RentRequest request, Model model) throws WriterException, IOException {
        ModelMapper modelMapper = new ModelMapper();
        Item item = itemService.findById(request.getItemId());
        User user = userService.finById(request.getUserId());

        Rent rent = rentService.save(new Rent(request.getTotalRent(), request.getTotalPrice(), request.getDateStart(),
                request.getDateEnd(), item, user));

        RentModel temp = modelMapper.map(rent, RentModel.class);

        RentModel qrCodePath = writeQR(temp);
        model.addAttribute("code", qrCodePath);
        return "QRcode Success Add";
    }

    @GetMapping("/readqr")
    public String verifyQR(@RequestParam String qrImage, Model model) throws Exception {
        model.addAttribute("content", readQR(qrImage));
        model.addAttribute("code", qrImage);
        return "QRcode Success Read";

    }

    private RentModel writeQR(RentModel request) throws WriterException, IOException {
        String qcodePath = "src/main/resources/static/images/" + request.getId() + "-QRCode.png";
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                "Rent Id " + request.getId() + "\n" + "Total Rent " + request.getTotalRent() + "\n" + "Total Price "
                        + request.getTotalPrice() + "\n" + "Date Start " + request.getDateStart() + "\n" + "Date End "
                        + request.getDateEnd() + "\n" + "Item " + request.getItem() + "\n" + "User " + request.getUser(),
                BarcodeFormat.QR_CODE, 350, 350);
        Path path = FileSystems.getDefault().getPath(qcodePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        return null;
    }

    private String readQR(String qrImage) throws Exception {
        final Resource fileResource = resourceLoader.getResource("classpath:static/images/" + qrImage);
        File QRfile = fileResource.getFile();
        BufferedImage bufferedImg = ImageIO.read(QRfile);
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImg);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result = new MultiFormatReader().decode(bitmap);
        System.out.println("Barcode Format: " + result.getBarcodeFormat());
        System.out.println("Text\n" + result.getText());
        return result.getText();

    }

}