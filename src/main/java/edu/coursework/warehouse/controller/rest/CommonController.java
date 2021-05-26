package edu.coursework.warehouse.controller.rest;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    CommonController
    @version:    1.0.0
    @since:    14.04.2021
*/

/*http://localhost:8080/title=Старчук Богдан Віталійович*/
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class CommonController {

    @RequestMapping(value = "/")
    public String showHome() {
        String word = "<h1>Start Page</h1>";
        return word;
    }

    @RequestMapping(value = "/title={name}")
    public String showTitlePage(@PathVariable("name") String name) {

        String theme = "Створення потокового відео сервісу з системою рекомендацій контенту";
        String courseNumber = "243";
        String courseName ="243 – Інженерія програмного забезпечення";

        String title = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Титульна сторінка</title>\n" +
                "    <link rel=\"stylesheet\" href=\"styletitle.css\"></link>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<div class=\"wrapper\">\n" +
                "\t\t<header class=\"header\">\n" +
                "\t\t\t<div class=\"container\">\n" +
                "\t\t\t\t<div class=\"header__title\">\n" +
                "\t\t\t\t\t<div class=\"header__title-str\">\n" +
                "\t\t\t\t\t\t<p>Міністерство освіти і науки України</p>\n" +
                "\t\t\t\t\t\t<p>Чернівецький національний університет імені Юрія Федьковича</p>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"header__title-str subtitle\">\n" +
                "\t\t\t\t\t\t<p>Інженерія програмного забезпечення комп’ютерних систем</p>\n" +
                "\t\t\t\t\t\t<hr>\n" +
                "\t\t\t\t\t\t<p>(повна назва кафедри, циклової комісії)</p>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</div>\t\n" +
                "\t\t\t</div>\n" +
                "\t\t</header>\n" +
                "\t\t<section class=\"body\">\n" +
                "\t\t\t<div class=\"conteiner\">\n" +
                "\t\t\t\t<div class=\"body__title subtitle maintitle\">\n" +
                "\t\t\t\t\t<h1>КУРСОВИЙ ПРОЕКТ</h1>\n" +
                "\t\t\t\t\t<p>З Java Технологій</p>\n" +
                "\t\t\t\t\t<hr>\n" +
                "\t\t\t\t\t<p>(назва дисципліни)</p>\n" +
                "\t\t\t\t</div>\n" +
                "\n" +
                "\t\t\t\t<div class=\"body__title maintitle\">\n" +
                "\t\t\t\t\t<h1 style=\"text-align:center\">" + theme + "</h1>\n" +
                "\t\t\t\t</div>\n" +
                "\n" +
                "\t\t\t\t<div class=\"body__title body__text-rigth\">\n" +
                "\t\t\t\t\t<p>Виконав (ла): студент (ка) 2 курсу, групи" + courseNumber + "</p> \n" +
                "\t\t\t\t\t<p>спеціальності</p>\n" +
                "\t\t\t\t\t<p>" + courseName + "</p>\n" +
                "\t\t\t\t\t<hr>\n" +
                "\t\t\t\t\t<p class=\"subtitle\">(шифр – назва спеціальності)</p>\n" +
                "\n" +
                "\t\t\t\t\t<p>" + name + "</p>\n" +
                "\t\t\t\t\t<hr>\n" +
                "\t\t\t\t\t<p class=\"subtitle\">(прізвище, ім’я, по-батькові студента)</p>\n" +
                "\n" +
                "\t\t\t\t\t<p>Керівник Прохоров Г. В.</p>\n" +
                "\t\t\t\t\t<hr>\n" +
                "\t\t\t\t\t<p class=\"subtitle\">(підпис) (прізвище та ініціали)</p> \n" +
                "\t\t\t\t</div>\n" +
                "\n" +
                "\t\t\t\t<div class=\"body__title body__text-left\">\n" +
                "\t\t\t\t\t\t<p>Нормоконтролер</p>\n" +
                "\t\t\t\t\t\t<hr>\n" +
                "\t\t\t\t\t    <p class=\"subtitle\">(підпис) (прізвище та ініціали)</p>\n" +
                "\t\t\t\t\t    <p><b>До захисту допущено:</b></p>\n" +
                "\t\t\t\t\t    <p><b>Протокол засідання кафедри № _____</b></p>\n" +
                "\t\t\t\t\t    <p>від „___”_______2021 р.</p>\n" +
                "\t\t\t\t\t    <p>зав. кафедри_______проф. Остапов С.Е.</p>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t\t\t\n" +
                "\t\t</section>\n" +
                "\t\t<footer>\n" +
                "\t\t\t<p>Чернівці - 2021</p>\n" +
                "\t\t</footer>\n" +
                "\t</div>\n" +
                "</body>\n" +
                "</html>";

        return title;
    }
}
