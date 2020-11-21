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

            //页面加载时候缓慢显示
            for (key in needLoadThTd) {
                $("." + needLoadThTd[key]).fadeIn(1500);
                $("." + needLoadThTd[key]);

                $("#" + needLoadThTd[key]).attr("checked", true);

                //loadFunction(needLoadThTd[key]);

            }
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


        });


         $("#ZHENZHIMIANMAOSELECT").change(function () {
            zhenzhimianmao = $('#ZHENZHIMIANMAOSELECT option:selected').val();
            $("#ZHENZHIMIANMAOINPUT").val(zhenzhimianmao)
        })

         $("#XUELISELECT").change(function () {
            xueli = $('#XUELISELECT option:selected').val();
            $("#XUELIINPUT").val(xueli)
        })


        $("#table123 tr").each(function(index, item) {
            //3.2 获取第一个td的值
            var id = $(item).children("td").get(0).innerHTML;
            var tableData = new Object();
            if(id == 0) {
            } else {
                tableData.Name = $(item).children("td").get(1).innerHTML;
                tableData.Sex = $(item).children("td").get(2).innerHTML;
                tableData.Age = $(item).children("td").get(3).innerHTML;
                tableData.College = $(item).children("td").get(4).innerHTML;
                tableData.Address = $(item).children("td").get(5).innerHTML;
                newArray.push(tableData);
            }
        });
        function changeValue(obj){
            console.log(obj.value);
        }
        var needLoadThTd = [];
    </script>
</head>
<body>
<form id="submitForm" name="submitForm" action="updateTraining.action" method="post" target="_parent">
    <input type="hidden" name="trainingbean.TID" value="${trainingbean.TID}" id=""/>
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
                    <td colspan="4">==培训信息========================================</td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="400">培训时间</td>
                    <td width="179" class="ui_text_lt"><input type="date" id="TRAININGDATE" name="trainingbean.TRAININGDATE"
                                                              value="${trainingbean.TRAININGDATE}" format="yyyy-MM-dd"
                                                              class="ui_input_txt02"/>
                    </td>
                    <td width="100" class="ui_text_rt">目的</td>
                    <td width="1025" class="ui_text_lt"><input type="text" id="GOAL" name="trainingbean.GOAL"
                                                               value="${trainingbean.GOAL}" class="ui_input_txt02"
                    /></td>
                </tr>
                <tr>
                    <td width="400" class="ui_text_rt">培训主题</td>
                    <td width="179" class="ui_text_lt"><input type="text" id="SUBJECT"
                                                               name="trainingbean.SUBJECT"
                                                               value="${trainingbean.SUBJECT}"
                                                               class="ui_input_txt02" onkeyup="go()"/></td>
                    <td class="ui_text_rt" width="180">地点</td>
                    <td width="1025" class="ui_text_lt"><input name="trainingbean.LOCATION"
                                                              id="LOCATION"
                                                              class="ui_input_txt02"
                                                              value="${trainingbean.LOCATION}"/>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt">主讲人</td>
                    <td class="ui_text_lt">
                        <input type="text" id="SPEAKER" name="trainingbean.SPEAKER"
                               value="${trainingbean.SPEAKER}"
                               class="ui_input_txt02"
                        />
                    </td>
                    <td width="400" class="ui_text_rt">记录人</td>
                    <td width="1025" class="ui_text_lt"><input type="text" id="NOTEKEEPER" name="trainingbean.NOTEKEEPER"
                                                               value="${trainingbean.NOTEKEEPER}" class="ui_input_txt02"
                    /></td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="200">内容</td>
                    <td width="200" class="ui_text_lt"><textarea height = "auto" class="ui_area01" warp="true"id="CONTENT"
                                                              name="trainingbean.CONTENT"
                                                              value="${trainingbean.CONTENT}">${trainingbean.CONTENT} </textarea>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="200">培训效果评估</td>
                    <td width="200" class="ui_text_lt"><textarea height = "auto" class="ui_area01" warp="true"id="EVALUATION"
                                                                 name="trainingbean.EVALUATION"
                                                                 value="${trainingbean.EVALUATION}">${trainingbean.EVALUATION} </textarea>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="200">备注</td>
                    <td width="200" class="ui_text_lt"><textarea height = "auto" class="ui_area01" warp="true"id="REMARK"
                                                                 name="trainingbean.REMARK"
                                                                 value="${trainingbean.REMARK}">${trainingbean.REMARK} </textarea>
                    </td>
                </tr>
                <tr>
                    <td width="180" class="ui_text_rt">课时</td>
                    <td colspan="3" width="1025" class="ui_text_lt"><input type="text" id="CLASSHOUR"
                                                                           name="trainingbean.CLASSHOUR"
                                                                           value="${trainingbean.CLASSHOUR}"
                                                                           class="ui_input_txt02"/></td>
                </tr>
                <tr>
                    <td colspan="4">==人员名单=========================================</td>
                </tr>
                <div class="ui_content">
                    <div class="ui_tb">
                        <table id="table123" class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
                            <tr>
                                <th class="PID" hidden="true">PID</th>
                                <th class="TID" hidden="true">TID</th>
                                <th class="XINMIN" >姓名</th>
                                <th class="ABSENT" >未参加培训</th>
                                <th class="REASON" >未参加培训原因</th>
                                <th class="RETRAININGDATE" >计划补训时间</th>
                                <th class="RESULT" >成绩</th>
                            </tr>
                            <s:iterator value="trainingbean.PERSON2TRAINING" id="a" status="st">
                                <tr>
                                    <td class="PID" hidden="true" ><input type="text" name="trainingbean.PERSON2TRAINING.PID" class="all" value="${a.PID}"
                                    /></td></td>
                                    <td class="TID" hidden="true" ><input type="text" name="trainingbean.PERSON2TRAINING.TID" class="all" value="${a.TID}"
                                    /></td></td>
                                    <td class="XINMIN" ><s:property value="#a.XINMIN"/></td>
                                    <td class="ABSENT" ><input type="text" name="trainingbean.PERSON2TRAINING.ABSENT" class="all" value="${a.ABSENT}"
                                                               /></td>
                                    <td class="REASON" ><input type="text" name="trainingbean.PERSON2TRAINING.REASON" onchange="changeValue(this);" class="all" value="${a.REASON}"
                                                               /></td>
                                    <td class="RETRAININGDATE" ><input type="date" name="trainingbean.PERSON2TRAINING.RETRAININGDATE" class="all" value="${a.RETRAININGDATE}"
                                                                       /></td>
                                    <td class="RESULT" >
                                        <select name="trainingbean.PERSON2TRAINING.RESULT" cssClass="input4">
                                            <option value="${a.RESULT}">
                                                    ${a.RESULT}
                                            </option>
                                            <c:if test="${a.RESULT=='不合格'}">
                                              <option value="合格">合格</option>
                                            </c:if>
                                            <c:if test="${a.RESULT=='合格'}">
                                              <option value="不合格">不合格</option>
                                            </c:if>
                                        </select>
                                    </td>
                                </tr>
                            </s:iterator>

                        </table>
                    </div>
                </div>
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