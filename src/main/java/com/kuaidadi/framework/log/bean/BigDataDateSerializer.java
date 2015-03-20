package com.kuaidadi.framework.log.bean;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/***
 * 大数据日志日志的格式化（适用json）
 * @author lingguoshen
 *
 */
public class BigDataDateSerializer extends JsonSerializer<Date> {
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");

    @Override
    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
                                                                                      JsonProcessingException {
        String formattedDate = formatter.format(value);
        jgen.writeString(formattedDate);

    }

}
