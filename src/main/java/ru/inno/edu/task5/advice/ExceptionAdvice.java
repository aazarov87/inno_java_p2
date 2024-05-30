package ru.inno.edu.task5.advice;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.inno.edu.task5.dto.Response;
import ru.inno.edu.task5.exceptions.EmptyFieldInputData;
import ru.inno.edu.task5.exceptions.NotExistsData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(EmptyFieldInputData.class)
    public ResponseEntity<Response> handleException(EmptyFieldInputData e) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message:", e.getMessage());
        Response response = new Response(body);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(NotExistsData.class)
    public ResponseEntity<Response> handleException(NotExistsData e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Response> handleException(EntityNotFoundException e) {
        Response response = new Response(e.getMessage() +" "+ e.getLocalizedMessage());
        e.getLocalizedMessage();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    //перехватываем ошибки БД
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> exception(DataIntegrityViolationException e) {
        String exceptionMsg = e.getMostSpecificCause().getMessage();
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("message:", exceptionMsg);
        body.put("StackTrace", e.getStackTrace());

        return new ResponseEntity<>(new Response(body), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    //валидация параметров
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<Object>  onMethodArgumentNotValidException(
            MethodArgumentNotValidException e
    ) {
        final List<Response> responses = e.getBindingResult().getFieldErrors().stream()
                .map(error -> new Response(error.getField() + " "+ error.getDefaultMessage()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(responses, HttpStatus.BAD_REQUEST);
    }
}
