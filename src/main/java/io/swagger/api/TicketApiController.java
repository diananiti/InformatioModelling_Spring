package io.swagger.api;

import io.swagger.model.Ticket;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-05T09:10:50.989Z")

@Controller
public class TicketApiController implements TicketApi {

    private static final Logger log = LoggerFactory.getLogger(TicketApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TicketApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addTicket(@ApiParam(value = "Add a new ticket to database" ,required=true )  @Valid @RequestBody Ticket body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteTicket(@ApiParam(value = "Ticket id to delete",required=true) @PathVariable("ticketId") Long ticketId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Ticket>> findTicketsByStatus(@NotNull @ApiParam(value = "Status values that need to be considered for filter", required = true, allowableValues = "available, pending, sold, canceled") @Valid @RequestParam(value = "status", required = true) List<String> status) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<List<Ticket>>(objectMapper.readValue("<Ticket>  <id>123456789</id>  <idUser>123456789</idUser>  <status>aeiou</status>  <DetailsTicket>aeiou</DetailsTicket></Ticket>", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<List<Ticket>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Ticket>>(objectMapper.readValue("[ {  \"idUser\" : 6,  \"id\" : 0,  \"DetailsTicket\" : \"DetailsTicket\",  \"status\" : \"available\"}, {  \"idUser\" : 6,  \"id\" : 0,  \"DetailsTicket\" : \"DetailsTicket\",  \"status\" : \"available\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Ticket>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Ticket>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Ticket> getTicketById(@ApiParam(value = "ID of ticket to return",required=true) @PathVariable("ticketId") Long ticketId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Ticket>(objectMapper.readValue("<Ticket>  <id>123456789</id>  <idUser>123456789</idUser>  <status>aeiou</status>  <DetailsTicket>aeiou</DetailsTicket></Ticket>", Ticket.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Ticket>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Ticket>(objectMapper.readValue("{  \"idUser\" : 6,  \"id\" : 0,  \"DetailsTicket\" : \"DetailsTicket\",  \"status\" : \"available\"}", Ticket.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Ticket>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Ticket>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateTicketWithForm(@ApiParam(value = "ID of ticket that needs to be updated",required=true) @PathVariable("ticketId") Long ticketId,@ApiParam(value = "Adds status of the ticket") @RequestParam(value="status", required=false)  String status) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
