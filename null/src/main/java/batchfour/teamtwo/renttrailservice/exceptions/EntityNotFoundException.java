package batchfour.teamtwo.renttrailservice.exceptions;

public class EntityNotFoundException extends ApplicationException {

    public EntityNotFoundException() {
        super("exception.entity.not.found", ErrorCodes.ENTITY_NOT_FOUND);
    }
}
