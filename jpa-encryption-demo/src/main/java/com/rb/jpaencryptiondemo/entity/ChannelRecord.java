package com.rb.jpaencryptiondemo.entity;

import java.io.Serializable;
import javax.persistence.AttributeConverter;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.Base64Utils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_channel_record")
public class ChannelRecord implements Serializable {
    @Id
    private String id;

    @Column(name = "request_param")
    @Convert(converter = EncryptConverter.class)
    private String requestParam;

    @Converter
    public static class EncryptConverter implements AttributeConverter<String, String> {
        @Override
        public String convertToDatabaseColumn(final String attribute) {
            return Base64Utils.encodeToString(attribute.getBytes());
        }

        @Override
        public String convertToEntityAttribute(final String dbData) {
            return new String(
                    Base64Utils.decodeFromString(dbData)
            );
        }
    }
}
