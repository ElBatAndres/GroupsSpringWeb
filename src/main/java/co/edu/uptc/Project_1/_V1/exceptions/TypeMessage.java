package co.edu.uptc.Project_1._V1.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum TypeMessage {
    NOT_DELETED(440, HttpStatus.BAD_REQUEST.value(), "Not deleted"),
    NOT_FOUND(404, HttpStatus.BAD_REQUEST.value(), "Not Found"),
    INFORMATION_INCOMPLETE(430, HttpStatus.BAD_REQUEST.value(), "Information Incomplete");

    public final int code, codeHttp;
    public final String message;

}
