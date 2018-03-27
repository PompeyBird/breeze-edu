package org.bird.breeze.edu.admin.controller;

import io.jsonwebtoken.Claims;
import org.apache.commons.text.RandomStringGenerator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.bird.breeze.edu.admin.service.ILessonSvc;
import org.bird.breeze.edu.bean.common.BreezeResult;
import org.bird.breeze.edu.bean.common.PageBean;
import org.bird.breeze.edu.bean.lesson.CheckInBean;
import org.bird.breeze.edu.bean.lesson.LessonFormBean;
import org.bird.breeze.edu.bean.lesson.LessonSearchBean;
import org.bird.breeze.edu.constants.MemberConstants;
import org.bird.breeze.edu.model.EduLesson;
import org.bird.breeze.edu.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/lessons")
@RestController
public class LessonController {

    @Autowired
    private ILessonSvc iLessonSvc;
    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public PageBean<EduLesson> queryLessons(LessonSearchBean searchBean, Integer pageStart,
                                            Integer pageSize, HttpServletRequest request){
        Claims claims = (Claims)request.getAttribute(MemberConstants.USER_CLAIMS);
        Integer userId = (Integer) claims.get("userId");
        return iLessonSvc.queryLessons(searchBean, userId, pageStart, pageSize);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public BreezeResult<Integer> addLesson(LessonFormBean lessonForm, HttpServletRequest request){
        Claims claims = (Claims)request.getAttribute(MemberConstants.USER_CLAIMS);
        Integer userId = (Integer) claims.get("userId");
        return iLessonSvc.addLesson(lessonForm, userId);
    }

    @RequestMapping(value = "/{lessonId}", method = RequestMethod.PUT)
    public BreezeResult<Integer> updateLesson(@PathVariable Integer lessonId, LessonFormBean lessonForm, HttpServletRequest request){
        lessonForm.setId(lessonId);
        Claims claims = (Claims)request.getAttribute(MemberConstants.USER_CLAIMS);
        Integer userId = (Integer) claims.get("userId");
        return iLessonSvc.updateLesson(lessonForm, userId);
    }

    @RequestMapping(value = "/{lessonId}", method = RequestMethod.GET)
    public BreezeResult<EduLesson> queryLessonById(@PathVariable Integer lessonId, HttpServletRequest request){
        Claims claims = (Claims)request.getAttribute(MemberConstants.USER_CLAIMS);
        Integer userId = (Integer) claims.get("userId");
        return iLessonSvc.queryLessonById(lessonId, userId);
    }

    @RequestMapping(value="/{lessonId}", method=RequestMethod.DELETE)
    public BreezeResult<Integer> deleteLessonById(@PathVariable Integer lessonId, HttpServletRequest request){
        Claims claims = (Claims)request.getAttribute(MemberConstants.USER_CLAIMS);
        Integer userId = (Integer) claims.get("userId");
        return iLessonSvc.deleteLessonById(lessonId, userId);
    }

    @RequestMapping(value="/code/{lessonId}", method=RequestMethod.GET)
    public Map<String,String> getCheckCode(@PathVariable Integer lessonId, HttpServletRequest request){
        RandomStringGenerator generator = new RandomStringGenerator
                .Builder().withinRange('0','9')
                .build();
        String checkCode = generator.generate(12);
        redisUtils.set("CHECK_CODE_"+lessonId, checkCode, 60);
        Map<String,String> map = new HashMap<String, String>(5);
        map.put("checkCode",checkCode);
        return map;
    }

    @RequestMapping(value = "/download/{lessonId}", method = RequestMethod.GET)
    public void downLoadCheckIn(@PathVariable Integer lessonId, HttpServletRequest request,
                                HttpServletResponse response) throws Exception {
//        Claims claims = (Claims)request.getAttribute(MemberConstants.USER_CLAIMS);
//        Integer userId = (Integer) claims.get("userId");
        BreezeResult<List<CheckInBean>> result = iLessonSvc.downLoadCheckIn(lessonId);
        if(!result.getSuccess()){
            throw new Exception("查询签到信息失败");
        }
        if(null == result.getData() || result.getData().size() == 0){
            throw new Exception("查询签到信息失败");
        }
        String lessonName = result.getData().get(0).getLessonName();
        HSSFWorkbook workbook = createExcel(lessonName, result.getData());
        exportExcel(response,lessonName+"-签到情况.xls",workbook);
    }

    private HSSFWorkbook createExcel(String sheetName, List<CheckInBean> checkIns){

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(sheetName);

        HSSFRow titleRow = sheet.createRow(0);

        HSSFCell cell = titleRow.createCell(0);
        cell.setCellType(CellType.STRING);
        cell.setCellValue("课程名称");

        HSSFCell cell1 = titleRow.createCell(1);
        cell1.setCellType(CellType.STRING);
        cell1.setCellValue("课程地点");

        HSSFCell cell2 = titleRow.createCell(2);
        cell2.setCellType(CellType.STRING);
        cell2.setCellValue("班级");

        HSSFCell cell3 = titleRow.createCell(3);
        cell3.setCellType(CellType.STRING);
        cell3.setCellValue("学号");

        HSSFCell cell4 = titleRow.createCell(4);
        cell4.setCellType(CellType.STRING);
        cell4.setCellValue("姓名");

        HSSFCell cell5 = titleRow.createCell(5);
        cell5.setCellType(CellType.STRING);
        cell5.setCellValue("签到时间");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for(int i = 0; i < checkIns.size(); i++){
            CheckInBean checkIn = checkIns.get(i);
            HSSFRow row = sheet.createRow(i + 1);

            HSSFCell valueCell = row.createCell(0);
            valueCell.setCellType(CellType.STRING);
            String value = checkIn.getLessonName();
            valueCell.setCellValue(value);

            HSSFCell valueCell1 = row.createCell(1);
            valueCell1.setCellType(CellType.STRING);
            String value1 = checkIn.getConcreteAddr();
            valueCell1.setCellValue(value1);

            HSSFCell valueCell2 = row.createCell(2);
            valueCell2.setCellType(CellType.STRING);
            valueCell2.setCellValue(checkIn.getClassId());

            HSSFCell valueCell3 = row.createCell(3);
            valueCell3.setCellType(CellType.STRING);
            valueCell3.setCellValue(checkIn.getStudentId());

            HSSFCell valueCell4 = row.createCell(4);
            valueCell4.setCellType(CellType.STRING);
            valueCell4.setCellValue(checkIn.getRealname());

            HSSFCell valueCell5 = row.createCell(5);
            valueCell5.setCellType(CellType.STRING);
            Date value5 = checkIn.getCheckInTime();
            if(value5 != null){
                valueCell5.setCellValue(format.format(value5));
            }
        }
        return workbook;
    }

    private void exportExcel(HttpServletResponse response, String fileName, HSSFWorkbook workbook) throws Exception {
        // 如果文件名有中文，必须URL编码
        fileName = URLEncoder.encode(fileName, "UTF-8");
//        response.reset();
//        // 告诉浏览器用什么软件可以打开此文件
//        response.setHeader("content-Type", "application/vnd.ms-excel");
//        // 下载文件的默认名称
//        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "utf-8"));
        // ContentType 可以不设置
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        try {
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            response.getOutputStream().flush();
            response.getOutputStream().close();
        }
    }
}
