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
 * �Զ������ݴ����ʽ������Ĭ�ϵ����л��뷴���л�������Excel��
 * @author AricSun
 * @date 2020.12.05 17:15
 */
//@Service  // ����ע�룬����Spring������������ȥ��������
public class ResponseToXlsConverter extends AbstractHttpMessageConverter<AjaxResponse> {
    private static final MediaType EXCEL_TYPE = MediaType.valueOf("application/vnd.ms-excel");

    public ResponseToXlsConverter() {
        super(EXCEL_TYPE);
    }

    // ��ʾ�費��Ҫ֧��
    @Override
    protected boolean supports(Class<?> aClass) {
        return (AjaxResponse.class == aClass);
    }

    //�����л����̣����RequestBody
    @Override
    protected AjaxResponse readInternal(Class<? extends AjaxResponse> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    // ���л����̣����ResponseBody��RestController������ResponseBody��Controller��
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
