<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>人员信息管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <script type="text/javascript" src="scripts/jquery/jquery-1.7.1.js"></script>
    <link href="style/authority/basic_layout.css" rel="stylesheet" type="text/css">
    <link href="style/authority/common_style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="scripts/authority/commonAll.js"></script>
    <script type="text/javascript" src="scripts/jquery/jquery-1.4.4.min.js"></script>
    <script src="scripts/My97DatePicker/WdatePicker.js" type="text/javascript" defer="defer"></script>
    <script type="text/javascript" src="scripts/artDialog/artDialog.js?skin=default"></script>
    <script type="text/javascript" src="scripts/util/shenfenzhen.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            /*
             * 提交
             */
            $("#submitbutton").click(function () {
                $("#submitForm").submit();
            });

            /*
             * 取消
             */
            $("#cancelbutton").click(function () {
                /**  关闭弹出iframe  **/
                window.parent.$.fancybox.close();
            });

            var result = 'null';
            if (result == 'success') {
                /**  关闭弹出iframe  **/
                window.parent.$.fancybox.close();
            }


            var zhenzhimianmao = $("#ZHENZHIMIANMAOINPUT").val(); //hidden 隐藏框的数据
            $("#ZHENZHIMIANMAOSELECT option[value = '" + zhenzhimianmao + "']").attr("selected", true);
            var xueli = $("#XUELIINPUT").val(); //hidden 隐藏框的数据
            $("#XUELISELECT option[value = '" + xueli + "']").attr("selected", true);
        });

        /**
         $("#ZHENZHIMIANMAOSELECT").change(function () {
            zhenzhimianmao = $('#ZHENZHIMIANMAOSELECT option:selected').val();
            $("#ZHENZHIMIANMAOINPUT").val(zhenzhimianmao)
        })

         $("#XUELISELECT").change(function () {
            xueli = $('#XUELISELECT option:selected').val();
            $("#XUELIINPUT").val(xueli)
        })
         */


    </script>
</head>
<body>
<form id="submitForm" name="submitForm" action="updatePersonal.action" method="post" target="_parent">
    <input type="hidden" name="personalbean.PID" value="${personalbean.PID}" id=""/>
    <div id="container">
        <div id="nav_links">
            当前位置：信息编辑</span>
            <div id="page_close">
                <a href="javascript:parent.$.fancybox.close();">
                    <img src="images/common/page_close.png" width="20" height="20" style="vertical-align: text-top;"/>
                </a>
            </div>
        </div>
        <div class="ui_content">
            <table cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
                <tr>
                    <td colspan="4">==基本信息=========================================</td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="180">姓名</td>
                    <td width="179" class="ui_text_lt"><input type="text" id="XINMININPUT" name="personalbean.XINMIN"
                                                              value="${personalbean.XINMIN}" class="ui_input_txt02"/>
                    </td>
                    <td width="180" class="ui_text_rt">身份证</td>
                    <td width="1025" class="ui_text_lt"><input type="text" id="SHENFENZHENINPUT"
                                                               name="personalbean.SHENFENZHEN"
                                                               value="${personalbean.SHENFENZHEN}"
                                                               class="ui_input_txt02" onkeyup="go()"/></td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="180">性别</td>
                    <td width="179" class="ui_text_lt"><input name="personalbean.XINBIE"
                                                              id="XINBIEINPUT"
                                                              class="ui_input_txt02"
                                                              value="${personalbean.XINBIE}"/>
                    </td>
                    <td width="180" class="ui_text_rt">籍贯</td>
                    <td width="1025" class="ui_text_lt"><input type="text" id="JIGUANINPUT" name="personalbean.JIGUAN"
                                                               value="${personalbean.JIGUAN}" class="ui_input_txt02"
                    /></td>
                </tr>
                <tr>
                    <td class="ui_text_rt">生日</td>
                    <td class="ui_text_lt">
                        <input type="date" id="SHENRIINPUT" name="personalbean.SHENRI"
                               value="<s:date name="personalbean.SHENRI" format="yyyy-MM-dd"/>"
                               class="ui_input_txt02"
                        />
                    </td>
                    <td class="ui_text_rt" width="180">学历</td>

                    <td class="ui_text_lt">
                        <input type="hidden" id="XUELIINPUT" name="personalbean.XUELI" value="${personalbean.XUELI}"/>
                        <select
                                id="XUELISELECT"
                                class="ui_select01">
                            <option value="">--请选择--</option>
                            <option value="专科">专科</option>
                            <option value="本科">本科</option>
                            <option value="硕士">硕士</option>
                            <option value="博士">博士</option>
                        </select>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="180">毕业院校</td>
                    <td width="179" class="ui_text_lt"><input type="text" id="BIYEYUANXIAOINPUT"
                                                              name="personalbean.BIYEYUANXIAO"
                                                              value="${personalbean.BIYEYUANXIAO}"
                                                              class="ui_input_txt02"/>
                    </td>
                    <td width="180" class="ui_text_rt">工作年月</td>
                    <td width="1025" class="ui_text_lt"><input type="date" id="GONGZUONIANYUE"
                                                               name="personalbean.GONGZUONIANYUE"
                                                               value="<s:date name="personalbean.GONGZUONIANYUE" format="yyyy-MM-dd"/>"
                                                               class="ui_input_txt02"/></td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="180">职务</td>
                    <td width="179" class="ui_text_lt"><input type="text" id="ZHIWUINPUT" name="personalbean.ZHIWU"
                                                              value="${personalbean.ZHIWU}" class="ui_input_txt02"/>
                    </td>
                    <td width="180" class="ui_text_rt">技术职务</td>
                    <td width="1025" class="ui_text_lt"><input type="text" id="JISHUZHIWUINPUT"
                                                               name="personalbean.JISHUZHIWU"
                                                               value="${personalbean.JISHUZHIWU}"
                                                               class="ui_input_txt02"/>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="180">职称</td>
                    <td width="179" class="ui_text_lt"><input type="text" id="ZHICHENINPUT" name="personalbean.ZHICHEN"
                                                              value="${personalbean.ZHICHEN}" class="ui_input_txt02"/>
                    </td>
                    <td width="180" class="ui_text_rt">政治面貌</td>
                    <td width="1025" class="ui_text_lt">
                        <input type="hidden" id="ZHENZHIMIANMAOINPUT" name="personalbean.ZHENZHIMIANMAO"
                               value="${personalbean.ZHENZHIMIANMAO}"/>
                        <select name="fangyuanEntity.fyHxCode"
                                id="ZHENZHIMIANMAOSELECT"
                                class="ui_select01">
                            <option value="">--请选择--</option>
                            <option value="党员">党员</option>
                            <option value="团员">团员</option>
                            <option value="群众">群众</option>
                            <option value="其他">其他</option>

                        </select>
                    </td>
                </tr>
                <tr>
                    <td width="180" class="ui_text_rt">家庭住址</td>
                    <td colspan="3" width="1025" class="ui_text_lt"><input type="text" id="JIATINZHUZHIINPUT"
                                                                           name="personalbean.JIATINZHUZHI"
                                                                           value="${personalbean.JIATINZHUZHI}"
                                                                           class="ui_input_txt02"/></td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="180">手机</td>
                    <td width="179" class="ui_text_lt"><input type="text" id="SHOUJIINPUT" name="personalbean.SHOUJI"
                                                              value="${personalbean.SHOUJI}" class="ui_input_txt02"/>
                    </td>
                    <td width="180" class="ui_text_rt">宅电</td>
                    <td width="1025" class="ui_text_lt"><input type="text" id="ZHAIDIANINPUT"
                                                               name="personalbean.ZHAIDIAN"
                                                               value="${personalbean.ZHAIDIAN}" class="ui_input_txt02"/>
                    </td>
                </tr>

                <!-- <tr>
                        <td colspan="4"><img src="images/plus.jpg" border="0" width="25" height="25" onclick=""/></td>
                    </tr>  -->
                <tr>
                    <td colspan="4">==执照信息=========================================</td>
                </tr>
                <input type="hidden" name="personalbean.ZHIZHAO.ZHIZHAOID" value="${personalbean.ZHIZHAO.ZHIZHAOID}"/>
                <tr>
                    <td class="ui_text_rt" width="180">执照类型</td>
                    <input type="hidden" name="personalbean.ZHIZHAO.ZHIZHAOID"
                           value="${personalbean.ZHIZHAO.ZHIZHAOID}"/>
                    <td width="179" class="ui_text_lt"><input type="text" id="ZHIZHAOTYPEINPUT"
                                                              name="personalbean.ZHIZHAO.ZHIZHAOTYPE"
                                                              value="${personalbean.ZHIZHAO.ZHIZHAOTYPE}"
                                                              class="ui_input_txt02"/>
                    </td>
                    <td width="180" class="ui_text_rt"></td>
                    <td width="1025" class="ui_text_lt"></td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="180">有效期从：</td>
                    <td width="179" class="ui_text_lt"><input type="date" id="ZHIZHAODATEFROMINPUT"
                                                              name="personalbean.ZHIZHAO.ZHIZHAODATEFROM"
                                                              value="<s:date name="personalbean.ZHIZHAO.ZHIZHAODATEFROM" format="yyyy-MM-dd"/>"
                                                              class="ui_input_txt02"/>
                    </td>
                    <td width="180" class="ui_text_rt">至：</td>
                    <td width="1025" class="ui_text_lt"><input type="date" id="ZHIZHAODATETOINPUT"
                                                               name="personalbean.ZHIZHAO.ZHIZHAODATETO"
                                                               value="<s:date name="personalbean.ZHIZHAO.ZHIZHAODATETO" format="yyyy-MM-dd"/>"
                                                               class="ui_input_txt02"/></td>
                </tr>
                <input type="hidden" name="personalbean.ZHIZHAO2.ZHIZHAOID" value="${personalbean.ZHIZHAO2.ZHIZHAOID}"/>
                <tr>
                    <td class="ui_text_rt" width="180">执照类型</td>
                    <input type="hidden" name="personalbean.ZHIZHAO2.ZHIZHAOID"
                           value="${personalbean.ZHIZHAO2.ZHIZHAOID}"/>
                    <td width="179" class="ui_text_lt"><input type="text" id="ZHIZHAO2TYPEINPUT"
                                                              name="personalbean.ZHIZHAO2.ZHIZHAOTYPE"
                                                              value="${personalbean.ZHIZHAO2.ZHIZHAOTYPE}"
                                                              class="ui_input_txt02"/>
                    </td>
                    <td width="180" class="ui_text_rt"></td>
                    <td width="1025" class="ui_text_lt"></td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="180">有效期从：</td>
                    <td width="179" class="ui_text_lt"><input type="date" id="ZHIZHAO2DATEFROMINPUT"
                                                              name="personalbean.ZHIZHAO2.ZHIZHAODATEFROM"
                                                              value="<s:date name="personalbean.ZHIZHAO2.ZHIZHAODATEFROM" format="yyyy-MM-dd"/>"
                                                              class="ui_input_txt02"/>
                    </td>
                    <td width="180" class="ui_text_rt">至：</td>
                    <td width="1025" class="ui_text_lt"><input type="date" id="ZHIZHAO2DATETOINPUT"
                                                               name="personalbean.ZHIZHAO2.ZHIZHAODATETO"
                                                               value="<s:date name="personalbean.ZHIZHAO2.ZHIZHAODATETO" format="yyyy-MM-dd"/>"
                                                               class="ui_input_txt02"/></td>
                </tr>
                <input type="hidden" name="personalbean.ZHIZHAO3.ZHIZHAOID" value="${personalbean.ZHIZHAO3.ZHIZHAOID}"/>
                <tr>
                    <td class="ui_text_rt" width="180">执照类型</td>
                    <input type="hidden" name="personalbean.ZHIZHAO3.ZHIZHAOID"
                           value="${personalbean.ZHIZHAO3.ZHIZHAOID}"/>
                    <td width="179" class="ui_text_lt"><input type="text" id="ZHIZHAO3TYPEINPUT"
                                                              name="personalbean.ZHIZHAO3.ZHIZHAOTYPE"
                                                              value="${personalbean.ZHIZHAO3.ZHIZHAOTYPE}"
                                                              class="ui_input_txt02"/>
                    </td>
                    <td width="180" class="ui_text_rt"></td>
                    <td width="1025" class="ui_text_lt"></td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="180">有效期从：</td>
                    <td width="179" class="ui_text_lt"><input type="date" id="ZHIZHAO3DATEFROMINPUT"
                                                              name="personalbean.ZHIZHAO3.ZHIZHAODATEFROM"
                                                              value="<s:date name="personalbean.ZHIZHAO3.ZHIZHAODATEFROM" format="yyyy-MM-dd"/>"
                                                              class="ui_input_txt02"/>
                    </td>
                    <td width="180" class="ui_text_rt">至：</td>
                    <td width="1025" class="ui_text_lt"><input type="date" id="ZHIZHAO3DATETOINPUT"
                                                               name="personalbean.ZHIZHAO3.ZHIZHAODATETO"
                                                               value="<s:date name="personalbean.ZHIZHAO3.ZHIZHAODATETO" format="yyyy-MM-dd"/>"
                                                               class="ui_input_txt02"/></td>
                </tr>

                <tr>
                    <td colspan="4">==子女信息=========================================</td>
                </tr>
                <input type="hidden" name="personalbean.CHILD.CHILDID" value="${personalbean.CHILD.CHILDID}"/>
                <tr>
                    <td class="ui_text_rt" width="180">子女姓名</td>
                    <input type="hidden" name="personalbean.CHILD.CHILDID" value="${personalbean.CHILD.CHILDID}"/>
                    <td width="179" class="ui_text_lt"><input type="text" id="CHILDXINMININPUT"
                                                              name="personalbean.CHILD.CHILDXINMIN"
                                                              value="${personalbean.CHILD.CHILDXINMIN}"
                                                              class="ui_input_txt02"/>
                    </td>
                    <td width="180" class="ui_text_rt"></td>
                    <td width="1025" class="ui_text_lt"></td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="180">子女性别</td>
                    <td width="179" class="ui_text_lt"><input type="text" id="CHILDXINBIEINPUT"
                                                              name="personalbean.CHILD.CHILDXINBIE"
                                                              value="${personalbean.CHILD.CHILDXINBIE}"
                                                              class="ui_input_txt02"/>
                    </td>
                    <td width="180" class="ui_text_rt">子女生日</td>
                    <td width="1025" class="ui_text_lt"><input type="text" id="CHILDSHENRIINPUT"
                                                               name="personalbean.CHILD.CHILDSHENRI"
                                                               value="<s:date name="personalbean.CHILD.CHILDSHENRI" format="yyyy-MM-dd"/>"
                                                               class="ui_input_txt02"/></td>
                </tr>
                <input type="hidden" name="personalbean.CHILD2.CHILDID" value="${personalbean.CHILD2.CHILDID}"/>
                <tr>
                    <td class="ui_text_rt" width="180">子女姓名</td>
                    <input type="hidden" name="personalbean.CHILD2.CHILDID" value="${personalbean.CHILD2.CHILDID}"/>
                    <td width="179" class="ui_text_lt"><input type="text" id="CHILD2XINMININPUT"
                                                              name="personalbean.CHILD2.CHILDXINMIN"
                                                              value="${personalbean.CHILD2.CHILDXINMIN}"
                                                              class="ui_input_txt02"/>
                    </td>
                    <td width="180" class="ui_text_rt"></td>
                    <td width="1025" class="ui_text_lt"></td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="180">子女性别</td>
                    <td width="179" class="ui_text_lt"><input type="text" id="CHILD2XINBIEINPUT"
                                                              name="personalbean.CHILD2.CHILDXINBIE"
                                                              value="${personalbean.CHILD2.CHILDXINBIE}"
                                                              class="ui_input_txt02"/>
                    </td>
                    <td width="180" class="ui_text_rt">子女生日</td>
                    <td width="1025" class="ui_text_lt"><input type="text" id="CHILD2SHENRIINPUT"
                                                               name="personalbean.CHILD2.CHILDSHENRI"
                                                               value="<s:date name="personalbean.CHILD2.CHILDSHENRI" format="yyyy-MM-dd"/>"
                                                               class="ui_input_txt02"/></td>
                </tr>
                <input type="hidden" name="personalbean.CHILD3.CHILDID" value="${personalbean.CHILD3.CHILDID}"/>
                <tr>
                    <td class="ui_text_rt" width="180">子女姓名</td>
                    <input type="hidden" name="personalbean.CHILD3.CHILDID" value="${personalbean.CHILD3.CHILDID}"/>
                    <td width="179" class="ui_text_lt"><input type="text" id="CHILD3XINMININPUT"
                                                              name="personalbean.CHILD3.CHILDXINMIN"
                                                              value="${personalbean.CHILD3.CHILDXINMIN}"
                                                              class="ui_input_txt02"/>
                    </td>
                    <td width="180" class="ui_text_rt"></td>
                    <td width="1025" class="ui_text_lt"></td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="180">子女性别</td>
                    <td width="179" class="ui_text_lt"><input type="text" id="CHILD3XINBIEINPUT"
                                                              name="personalbean.CHILD3.CHILDXINBIE"
                                                              value="${personalbean.CHILD3.CHILDXINBIE}"
                                                              class="ui_input_txt02"/>
                    </td>
                    <td width="180" class="ui_text_rt">子女生日</td>
                    <td width="1025" class="ui_text_lt"><input type="text" id="CHILD3SHENRIINPUT"
                                                               name="personalbean.CHILD3.CHILDSHENRI"
                                                               value="<s:date name="personalbean.CHILD3.CHILDSHENRI" format="yyyy-MM-dd"/>"
                                                               class="ui_input_txt02"/></td>
                </tr>
                <tr>
                    <td colspan="4">==车辆信息=========================================</td>
                </tr>

                <tr>
                    <td class="ui_text_rt" width="180">车牌信息</td>
                    <input type="hidden" name="personalbean.CAR.CARID" value="${personalbean.CAR.CARID}"/>
                    <td width="179" class="ui_text_lt"><input type="text" id="CARCHEPAIINPUT"
                                                              name="personalbean.CAR.CARCHEPAI"
                                                              value="${personalbean.CAR.CARCHEPAI}"
                                                              class="ui_input_txt02"/>
                    </td>
                    <td width="180" class="ui_text_rt">登记日期</td>
                    <td width="1025" class="ui_text_lt"><input type="date" id="CARDENJIDATE"
                                                               name="personalbean.CAR.CARDENJIDATE"
                                                               value="<s:date name="personalbean.CAR.CARDENJIDATE" format="yyyy-MM-dd"/>"
                                                               class="ui_input_txt02"/></td>
                </tr>
                <input type="hidden" name="personalbean.CAR2.CARID" value="${personalbean.CAR2.CARID}"/>
                <tr>
                    <td class="ui_text_rt" width="180">车牌信息</td>
                    <input type="hidden" name="personalbean.CAR2.CARID" value="${personalbean.CAR2.CARID}"/>
                    <td width="179" class="ui_text_lt"><input type="text" id="CAR2CHEPAIINPUT"
                                                              name="personalbean.CAR2.CARCHEPAI"
                                                              value="${personalbean.CAR2.CARCHEPAI}"
                                                              class="ui_input_txt02"/>
                    </td>
                    <td width="180" class="ui_text_rt">登记日期</td>
                    <td width="1025" class="ui_text_lt"><input type="date" id="CAR2DENJIDATE"
                                                               name="personalbean.CAR2.CARDENJIDATE"
                                                               value="<s:date name="personalbean.CAR2.CARDENJIDATE" format="yyyy-MM-dd"/>"
                                                               class="ui_input_txt02"/></td>
                </tr>
                <input type="hidden" name="personalbean.CAR3.CARID" value="${personalbean.CAR3.CARID}"/>
                <tr>
                    <td class="ui_text_rt" width="180">车牌信息</td>
                    <input type="hidden" name="personalbean.CAR3.CARID" value="${personalbean.CAR3.CARID}"/>
                    <td width="179" class="ui_text_lt"><input type="text" id="CAR3CHEPAIINPUT"
                                                              name="personalbean.CAR3.CARCHEPAI"
                                                              value="${personalbean.CAR3.CARCHEPAI}"
                                                              class="ui_input_txt02"/>
                    </td>
                    <td width="180" class="ui_text_rt">登记日期</td>
                    <td width="1025" class="ui_text_lt"><input type="date" id="CAR3DENJIDATE"
                                                               name="personalbean.CAR3.CARDENJIDATE"
                                                               value="<s:date name="personalbean.CAR3.CARDENJIDATE" format="yyyy-MM-dd"/>"
                                                               class="ui_input_txt02"/></td>
                </tr>

                <tr>
                    <td colspan="4">================================================</td>
                </tr>
                <br/>
                <tr>
                    <td>&nbsp;</td>
                    <td class="ui_text_lt">
                        &nbsp;<input id="submitbutton" type="button" value="提交" class="ui_input_btn01"/>

                    </td>
                    <td class="ui_text_lt">&nbsp;</td>
                    <td class="ui_text_lt">&nbsp;<input id="cancelbutton" type="button" value="取消"
                                                        class="ui_input_btn01"/></td>
                </tr>
            </table>
        </div>
    </div>
</form>

</body>
</html>