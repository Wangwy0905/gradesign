package com.libei;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GradesignApplicationTests {

    @Test
    public void mappertest() {
        String content = "W-T 2020/3/26 17:56:10\n" +
                "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" style=\"font-family:&quot;Microsoft YaHei&quot;; font-size:12px; line-height:1.5em; width:890px; word-break:break-word\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"8\" rowspan=\"1\"><span style=\"font-size:16px\"><strong>应征人员履历表（正面）</strong></span></td>\n" +
                "\t\t\t<td colspan=\"2\" rowspan=\"1\" style=\"text-align:right\"><img style='max-width: 100%;height: auto;' alt=\"\" height=\"32\" src=\"http://app-dashboard.oss-cn-beijing.aliyuncs.com//dev/dashboard/proofTemplate/15846765750001682logo.png\" width=\"122\" /></td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"width:60px\">NO.</td>\n" +
                "\t\t\t<td style=\"width:100px\">&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</td>\n" +
                "\t\t\t<td style=\"width:100px\">应聘岗位</td>\n" +
                "\t\t\t<td colspan=\"4\" rowspan=\"1\" style=\"width:100px\">${EMPLOYEE_POST}&nbsp; &nbsp;</td>\n" +
                "\t\t\t<td colspan=\"3\" rowspan=\"1\" style=\"text-align:right; width:230px\">填表日期：&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;年&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 月&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 日</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "\n" +
                "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" id=\"resume\" style=\"border-bottom:1px solid #000000; border-right:1px solid #000000; font-family:&quot;Microsoft YaHei&quot;; font-size:12px; line-height:1.5em; width:890px; word-break:break-word\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"width:60px\">姓名</td>\n" +
                "\t\t\t<td style=\"width:100px\">${EMPLOYEE_NAME}</td>\n" +
                "\t\t\t<td style=\"width:100px\">性别</td>\n" +
                "\t\t\t<td style=\"width:100px\">${EMPLOYEE_SEX}</td>\n" +
                "\t\t\t<td style=\"width:100px\">年龄</td>\n" +
                "\t\t\t<td style=\"width:100px\">${EMPLOYEE_AGE}&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</td>\n" +
                "\t\t\t<td style=\"width:80px\">生日</td>\n" +
                "\t\t\t<td style=\"width:80px\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</td>\n" +
                "\t\t\t<td colspan=\"2\" rowspan=\"6\" style=\"width:150px\">贴照片处</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>籍贯</td>\n" +
                "\t\t\t<td>${EMPLOYEE_NATIVE}</td>\n" +
                "\t\t\t<td>民族</td>\n" +
                "\t\t\t<td>${EMPLOYEE_NATION}</td>\n" +
                "\t\t\t<td>婚姻状况</td>\n" +
                "\t\t\t<td>${EMPLOYEE_MARRIAGE}</td>\n" +
                "\t\t\t<td>文化程度</td>\n" +
                "\t\t\t<td>${EMPLOYEE_CULTURE}</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>身份证号码</td>\n" +
                "\t\t\t<td colspan=\"2\" rowspan=\"1\">${EMPLOYEE_IDNUM}</td>\n" +
                "\t\t\t<td>&nbsp;</td>\n" +
                "\t\t\t<td>户口性质</td>\n" +
                "\t\t\t<td>${PEOPLE_NATURE}</td>\n" +
                "\t\t\t<td>&nbsp;</td>\n" +
                "\t\t\t<td>&nbsp;</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>健康状况</td>\n" +
                "\t\t\t<td>&nbsp;</td>\n" +
                "\t\t\t<td>身高</td>\n" +
                "\t\t\t<td style=\"text-align:right\">cm</td>\n" +
                "\t\t\t<td>体重</td>\n" +
                "\t\t\t<td style=\"text-align:right\">kg</td>\n" +
                "\t\t\t<td>血型</td>\n" +
                "\t\t\t<td>&nbsp;</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" rowspan=\"1\">过往病史 或 法定传染病 或 精神病</td>\n" +
                "\t\t\t<td colspan=\"5\" rowspan=\"1\">&nbsp;</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>抚养亲人数</td>\n" +
                "\t\t\t<td>&nbsp;</td>\n" +
                "\t\t\t<td>宗教信仰</td>\n" +
                "\t\t\t<td>${RELIGION}</td>\n" +
                "\t\t\t<td colspan=\"2\" rowspan=\"1\">人事关系存档单位</td>\n" +
                "\t\t\t<td colspan=\"2\" rowspan=\"1\">&nbsp;</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>户籍地址</td>\n" +
                "\t\t\t<td colspan=\"5\" rowspan=\"1\">${REGISTERED_PLACE}</td>\n" +
                "\t\t\t<td>（邮编：</td>\n" +
                "\t\t\t<td>&nbsp;</td>\n" +
                "\t\t\t<td colspan=\"2\">&nbsp;</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>通讯地址</td>\n" +
                "\t\t\t<td colspan=\"5\" rowspan=\"1\">${POSTAL_LOCATION}</td>\n" +
                "\t\t\t<td>（邮编：</td>\n" +
                "\t\t\t<td>&nbsp;</td>\n" +
                "\t\t\t<td colspan=\"2\">&nbsp;</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"3\" rowspan=\"1\">能否接受公司调动（职务或工作地点）？</td>\n" +
                "\t\t\t<td style=\"text-align:right\">&nbsp;</td>\n" +
                "\t\t\t<td>能否再次入职</td>\n" +
                "\t\t\t<td style=\"text-align:right\">&nbsp;</td>\n" +
                "\t\t\t<td>可接受的工作地点</td>\n" +
                "\t\t\t<td colspan=\"3\" rowspan=\"1\">&nbsp;</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"4\" rowspan=\"2\">您有亲友在本公司任职吗？</td>\n" +
                "\t\t\t<td>姓名</td>\n" +
                "\t\t\t<td>&nbsp;</td>\n" +
                "\t\t\t<td>称谓</td>\n" +
                "\t\t\t<td colspan=\"3\" rowspan=\"1\">&nbsp;</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>姓名</td>\n" +
                "\t\t\t<td>&nbsp;</td>\n" +
                "\t\t\t<td>称谓</td>\n" +
                "\t\t\t<td colspan=\"3\" rowspan=\"1\">&nbsp;</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"2\" rowspan=\"2\">紧急联络人<br />\n" +
                "\t\t\t（请提供两位亲朋电话，以便联络）</td>\n" +
                "\t\t\t<td>姓名</td>\n" +
                "\t\t\t<td style=\"text-align:right\">&nbsp;</td>\n" +
                "\t\t\t<td>联络电话</td>\n" +
                "\t\t\t<td style=\"text-align:right\">&nbsp;</td>\n" +
                "\t\t\t<td colspan=\"1\" rowspan=\"2\">机动车驾驶证</td>\n" +
                "\t\t\t<td colspan=\"3\" rowspan=\"1\">&nbsp;</td>\n" +
                "\t\t</tr>\n" +
                "\t\n" +
                "\t\n" +
                "\t</tbody>\n" +
                "</table>\n";
        String disrPath = "D:\\idea";
        String fileName = UUID.randomUUID().toString();

        try {

            String templateContent = new String(content.getBytes());
            String fileame = fileName + ".html";
            fileame = disrPath + "/" + fileame;// 生成的html文件保存路径。
            FileOutputStream fileoutputstream = new FileOutputStream(fileame);// 建立文件输出流
            System.out.print("文件输出路径:");
            System.out.print(fileame);
            byte tag_bytes[] = templateContent.getBytes();
            fileoutputstream.write(tag_bytes);
            fileoutputstream.close();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }

}


