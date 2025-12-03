package hello.typeconverter.converter;

import static org.assertj.core.api.Assertions.*;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

public class ConversionServiceTest {

    @Test
    void conversionService(){
        DefaultConversionService conver = new DefaultConversionService();
        //등록
        conver.addConverter(new IntegerToStringConverter());
        conver.addConverter(new IpPortToStringConverter());
        conver.addConverter(new StringToIntegerConverter());
        conver.addConverter(new StringToIpPortConverter());

        //사용
        assertThat(conver.convert(10, String.class)).isEqualTo("10");
        assertThat(conver.convert(10, String.class)).isEqualTo("10");
        assertThat(conver.convert("127.00.0.1:8080", IpPort.class)).isEqualTo(new IpPort("127.00.0.1",8080));
        assertThat(conver.convert(new IpPort("127.00.0.1",8080), String.class)).isEqualTo("127.00.0.1:8080");
    }
}
