package co.edu.uptc.Project_1._V1.exceptions;

public class ProjectException extends Exception {
    private TypeMessage typeMessage;

    public ProjectException(TypeMessage typeMessage) {
        super(typeMessage.message);
        this.typeMessage = typeMessage;
    }

    public Message getMassageType(){
        return new Message(this.typeMessage.code, this.typeMessage.codeHttp, this.typeMessage.message);
    }

}
