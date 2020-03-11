package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Ticket
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-05T09:10:50.989Z")

public class Ticket   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("idUser")
  private Long idUser = null;

  /**
   * ticket status in the store
   */
  public enum StatusEnum {
    AVAILABLE("available"),
    
    PENDING("pending"),
    
    CANCELED("canceled"),
    
    SOLD("sold");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("DetailsTicket")
  private String detailsTicket = null;

  public Ticket id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Ticket idUser(Long idUser) {
    this.idUser = idUser;
    return this;
  }

  /**
   * Get idUser
   * @return idUser
  **/
  @ApiModelProperty(value = "")


  public Long getIdUser() {
    return idUser;
  }

  public void setIdUser(Long idUser) {
    this.idUser = idUser;
  }

  public Ticket status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * ticket status in the store
   * @return status
  **/
  @ApiModelProperty(value = "ticket status in the store")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Ticket detailsTicket(String detailsTicket) {
    this.detailsTicket = detailsTicket;
    return this;
  }

  /**
   * Get detailsTicket
   * @return detailsTicket
  **/
  @ApiModelProperty(value = "")


  public String getDetailsTicket() {
    return detailsTicket;
  }

  public void setDetailsTicket(String detailsTicket) {
    this.detailsTicket = detailsTicket;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ticket ticket = (Ticket) o;
    return Objects.equals(this.id, ticket.id) &&
        Objects.equals(this.idUser, ticket.idUser) &&
        Objects.equals(this.status, ticket.status) &&
        Objects.equals(this.detailsTicket, ticket.detailsTicket);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, idUser, status, detailsTicket);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ticket {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idUser: ").append(toIndentedString(idUser)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    detailsTicket: ").append(toIndentedString(detailsTicket)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

