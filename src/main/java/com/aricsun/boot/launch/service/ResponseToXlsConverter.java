package com.aricsun.boot.launch.service;

import com.aricsun.boot.launch.AjaxResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 自定义数据处理格式，代替默认的序列化与反序列化操作（Excel）
 * @author AricSun
 * @date 2020.12.05 17:15
 */
//@Service  // 依赖注入，交给Spring容器，由容器去创建对象
public class ResponseToXlsConverter extends AbstractHttpMessageConverter<AjaxResponse> {
    private static final MediaType EXCEL_TYPE = MediaType.valueOf("application/vnd.ms-excel");

    public ResponseToXlsConverter() {
        super(EXCEL_TYPE);
    }

    // 表示需不需要支持
    @Override
    protected boolean supports(Class<?> aClass) {
        return (AjaxResponse.class == aClass);
    }

    //反序列化过程，针对RequestBody
    @Override
    protected AjaxResponse readInternal(Class<? extends AjaxResponse> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    // 序列化过程，针对ResponseBody（RestController集成了ResponseBody和Controller）
    @Override
    protected void writeInternal(AjaxResponse ajaxResponse, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        final Workbook workbook = new HSSFWorkbook();
        final Sheet sheet = workbook.createSheet();

        final Row row = sheet.createRow(0);
        row.createCell(0).setCellValue(ajaxResponse.getMessage());
        row.createCell(1).setCellValue(ajaxResponse.getData().toString());

        workbook.write(httpOutputMessage.getBody());
    }
}
