package de.markushanses.finance.haspa.retriever.adapter.rabbitmq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RawBankAccountMessage implements Serializable {

    private String buchung;
    private String verwendungszweck;
    private BigDecimal betrag;

}
