package com.example.cbr.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Table(name = "tbl_currency")
@XmlRootElement(name = "Currency")
@XmlAccessorType(XmlAccessType.FIELD)
public class Currency {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @XmlElement(name = "NumCode")
        private String numCode;

        @XmlElement(name = "CharCode")
        private String charCode;

        @XmlElement(name = "Nominal")
        private int nominal;

        @XmlElement(name = "Name")
        private String name;

        @XmlElement(name = "Value")
        @JsonIgnore
        @Transient
        private String _Value;

        private double value;

        public Currency(Long id, String numCode, String charCode, int nominal, String name, double value) {
                this.id = id;
                this.numCode = numCode;
                this.charCode = charCode;
                this.nominal = nominal;
                this.name = name;
                this.value = value;
        }

        public String get_Value() {
                return _Value;
        }

        public void setValue(double value) {
                this.value = value;
        }

        @XmlElement(name = "Date")
        private Date date;

        @Override
        public String toString() {
                return "\n" + name + " (" +
                        "numCode = " + numCode + ", " +
                        "charCode = " + charCode + ", " +
                        "nominal = " + nominal + ", " +
                        "value = " + value + ")";
        }

        public Long getId() {
                return id;
        }

        public String getNumCode() {
                return numCode;
        }

        public String getCharCode() {
                return charCode;
        }

        public int getNominal() {
                return nominal;
        }

        public String getName() {
                return name;
        }

        public double getValue() {
                return value;
        }

        public Date getDate() {
                return date;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public void setNumCode(String numCode) {
                this.numCode = numCode;
        }

        public void setCharCode(String charCode) {
                this.charCode = charCode;
        }

        public void setNominal(int nominal) {
                this.nominal = nominal;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void set_Value(String _Value) {
                this._Value = _Value;
        }

        public void setDate(Date date) {
                this.date = date;
        }
}
