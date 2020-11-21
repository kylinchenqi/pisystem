<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="scripts/jquery/jquery-1.7.1.js"></script>
    <link href="style/authority/basic_layout.css" rel="stylesheet" type="text/css">
    <link href="style/authority/common_style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="scripts/authority/commonAll.js"></script>
    <script type="text/javascript" src="scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
    <script type="text/javascript" src="scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
    <link rel="stylesheet" type="text/css" href="style/authority/jquery.fancybox-1.3.4.css" media="screen"></link>
    <script type="text/javascript" src="scripts/artDialog/artDialog.js?skin=default"></script>
    <title>信息管理系统</title>
    <script type="text/javascript">
        $(document).ready(function () {

            var dangqianweizhi = $('#here_area', parent.document).html();

            //根据当前位置设置显示的列项
            if (dangqianweizhi == "人员信息") {
                needLoadThTd = ["CAOZUO", "CHECKBOXALL", "XINMIN", "SHENRI", "JIGUAN", "ZHIWU", "JISHUZHIWU", "ZHENZHIMIANMAO", "SHOUJI"];
            }
            if (dangqianweizhi == "通讯录") {
                needLoadThTd = ["CAOZUO", "CHECKBOXALL", "XINMIN", "ZHIWU", "SHOUJI", "ZHAIDIAN", "JIATINZHUZHI"];
            }
            if (dangqianweizhi == "党员信息") {
                needLoadThTd = ["CAOZUO", "CHECKBOXALL", "XINMIN", "ZHIWU", "ZHENZHIMIANMAO", "SHOUJI"];
            }
            if (dangqianweizhi == "团员青年信息") {
                needLoadThTd = ["CAOZUO", "CHECKBOXALL", "XINMIN", "ZHIWU", "ZHENZHIMIANMAO", "SHOUJI"];
            }
            if (dangqianweizhi == "执照信息") {
                needLoadThTd = ["CAOZUO", "CHECKBOXALL", "ZHIZHAOTYPE", "XINMIN", "ZHIWU", "ZHICHEN", "ZHIZHAODATEFROM", "ZHIZHAODATETO"];
            }
            if (dangqianweizhi == "车辆信息") {
                needLoadThTd = ["CAOZUO", "CHECKBOXALL", "XINMIN", "ZHIWU", "CARCHEPAI", "CARDENJIDATE", "SHOUJI"];
            }
            if (dangqianweizhi == "子女信息") {
                needLoadThTd = ["CAOZUO", "CHECKBOXALL", "XINMIN", "ZHIWU", "CHILDXINMIN", "CHILDXINBIE", "CHILDSHENRI", "SHOUJI"];
            }

            //页面加载时候缓慢显示
            for (key in needLoadThTd) {
                $("." + needLoadThTd[key]).fadeIn(1500);
                $("." + needLoadThTd[key]);

                $("#" + needLoadThTd[key]).attr("checked", true);

                //loadFunction(needLoadThTd[key]);

            }


            /** 新增   **/
            $("#addBtn").fancybox({
                'href': 'personal_edit.jsp',
                'width': 733,
                'height': 530,
                'type': 'iframe',
                'hideOnOverlayClick': false,
                'showCloseButton': false,
                'onClosed': function () {
                    window.location.href = 'listPersonal.action';
                }
            });

            /** 导入  **/
            $("#importBtn").fancybox({
                'href': '/xngzf/archives/importFangyuan.action',
                'width': 633,
                'height': 260,
                'type': 'iframe',
                'hideOnOverlayClick': false,
                'showCloseButton': false,
                'onClosed': function () {
                    window.location.href = 'house_list.html';
                }
            });

            /**编辑   **/
            $("a.edit").fancybox({
                'width': 733,
                'height': 530,
                'type': 'iframe',
                'hideOnOverlayClick': false,
                'showCloseButton': false,
                'onClosed': function () {
                    window.location.href = 'listPersonal.action';
                }
            });
        });
        /** 用户角色   **/
        var userRole = '';
        var needLoadThTd = [];
        var searchKeyword;


        function search() {
            $("#submitForm").attr("action", "search.action").submit();
        }

        /** 新增   **/
        function add() {
            $("#submitForm").attr("action", "/xngzf/archives/luruFangyuan.action").submit();
        }

        /** Excel导出  **/
        function exportExcel() {
            if (confirm('您确定要导出吗？')) {
                var fyXqCode = $("#fyXq").val();
                var fyXqName = $('#fyXq option:selected').text();
//	 		alert(fyXqCode);
                if (fyXqCode == "" || fyXqCode == null) {
                    $("#fyXqName").val("");
                } else {
//	 			alert(fyXqCode);
                    $("#fyXqName").val(fyXqName);
                }
                $("#submitForm").attr("action", "/xngzf/archives/exportExcelFangyuan.action").submit();
            }
        }

        /** 删除 **/
        function del(fyID) {
            // 非空判断
            if (fyID == '') return;
            if (confirm("您确定要删除吗？")) {
                $("#submitForm").attr("action", "/xngzf/archives/delFangyuan.action?fyID=" + fyID).submit();
            }
        }

        /** 批量删除 **/
        function batchDel() {
            if ($("input[name='IDCheck']:checked").size() <= 0) {
                art.dialog({icon: 'error', title: '友情提示', drag: false, resize: false, content: '至少选择一条', ok: true,});
                return;
            }
            // 1）取出用户选中的checkbox放入字符串传给后台,form提交
            var allIDCheck = "";
            $("input[name='IDCheck']:checked").each(function (index, domEle) {
                bjText = $(domEle).parent("td").parent("tr").last().children("td").last().prev().text();
// 			alert(bjText);
                // 用户选择的checkbox, 过滤掉“已审核”的，记住哦
                if ($.trim(bjText) == "已审核") {
// 				$(domEle).removeAttr("checked");
                    $(domEle).parent("td").parent("tr").css({color: "red"});
                    $("#resultInfo").html("已审核的是不允许您删除的，请联系管理员删除！！！");
// 				return;
                } else {
                    allIDCheck += $(domEle).val() + ",";
                }
            });
            // 截掉最后一个","
            if (allIDCheck.length > 0) {
                allIDCheck = allIDCheck.substring(0, allIDCheck.length - 1);
                // 赋给隐藏域
                $("#allIDCheck").val(allIDCheck);
                if (confirm("您确定要批量删除这些记录吗？")) {
                    // 提交form
                    $("#submitForm").attr("action", "/xngzf/archives/batchDelFangyuan.action").submit();
                }
            }
        }

        /** 普通跳转 **/
        function jumpNormalPage(page) {
            $("#submitForm").attr("action", "house_list.html?page=" + page).submit();
        }

        /** 输入页跳转 **/
        function jumpInputPage(totalPage) {
            // 如果“跳转页数”不为空
            if ($("#jumpNumTxt").val() != '') {
                var pageNum = parseInt($("#jumpNumTxt").val());
                // 如果跳转页数在不合理范围内，则置为1
                if (pageNum < 1 | pageNum > totalPage) {
                    art.dialog({
                        icon: 'error',
                        title: '友情提示',
                        drag: false,
                        resize: false,
                        content: '请输入合适的页数，\n自动为您跳到首页',
                        ok: true,
                    });
                    pageNum = 1;
                }
                $("#submitForm").attr("action", "house_list.html?page=" + pageNum).submit();
            } else {
                // “跳转页数”为空
                art.dialog({
                    icon: 'error',
                    title: '友情提示',
                    drag: false,
                    resize: false,
                    content: '请输入合适的页数，\n自动为您跳到首页',
                    ok: true,
                });
                $("#submitForm").attr("action", "house_list.html?page=" + 1).submit();
            }
        }

        //checkbox触发事件缓慢显示checkbox的列
        function checkboxFunction(id) {
            /*if ($("#xxxx").prop('checked') == true) {
                $(".XINMIN").show();
            } else {
                $(".XINMIN").hide();
            }*/
            if ($("#" + id).is(':checked')) {
                //dosomething
                $("." + id).fadeIn(1000);
            } else {
                //dosomething
                $("." + id).fadeOut(1000);
            }
        }

        //没有使用
        function loadFunction(id) {
            $("." + id).fadeIn(1000);
            $("#" + id).attr("checked", true);

        }

        $(document).keydown(function (e) {
            if (e.keyCode == 13) {
                search();
            }
        });

        function blueAllSearchKeyword() {
            $("#searchKeyword").select();
        }


    </script>
    <style>
        .alt td {
            background: black !important;

        }

        td {
            word-break: keep-all !important;
            white-space: nowrap !important;
        }

        th {
            word-break: keep-all !important;
            white-space: nowrap !important;
        }
    </style>
</head>
<body>
<form id="submitForm" name="submitForm" action="search.action" method="post">
    <%--    <input type="hidden" name="allIDCheck" value="" id="allIDCheck"/>--%>
    <%--    <input type="hidden" name="fangyuanEntity.fyXqName" value="" id="fyXqName"/>--%>
    <div id="container">
        <div class="ui_content">
            <div class="ui_text_indent">
                <div id="box_border">
                    <div id="box_top">搜索</div>
                    <div id="box_center">

                        <%--                        <select name="fangyuanEntity.fyXqCode" id="fyXq" class="ui_select01"--%>
                        <%--                                onchange="getFyDhListByFyXqCode();">--%>
                        <%--                            <option value=""--%>
                        <%--                            >--请选择----%>
                        <%--                            </option>--%>
                        <%--                            <option value="6">瑞景河畔</option>--%>
                        <%--                            <option value="77">蔚蓝小区</option>--%>
                        <%--                            <option value="83">和盛园小区</option>--%>
                        <%--                        </select>--%>

                        <%--                        栋号--%>
                        <%--                        <select name="fangyuanEntity.fyDhCode" id="fyDh" class="ui_select01">--%>
                        <%--                            <option value="">--请选择--</option>--%>
                        <%--                        </select>--%>
                        <%--                        户型--%>
                        <%--                        <select name="fangyuanEntity.fyHxCode" id="fyHx" class="ui_select01">--%>
                        <%--                            <option value="">--请选择--</option>--%>
                        <%--                            <option value="76">一室一厅一卫</option>--%>
                        <%--                            <option value="10">两室一厅一卫</option>--%>
                        <%--                            <option value="14">三室一厅一卫</option>--%>
                        <%--                            <option value="71">三室两厅一卫</option>--%>
                        <%--                        </select>--%>
                        <%--                        状态--%>
                        <%--                        <select name="fangyuanEntity.fyStatus" id="fyStatus" class="ui_select01">--%>
                        <%--                            <option value="">--请选择--</option>--%>
                        <%--                            <option value="26">在建</option>--%>
                        <%--                            <option value="25">建成待租</option>--%>
                        <%--                            <option value="13">已配租</option>--%>
                        <%--                            <option value="12">已租赁</option>--%>
                        <%--                            <option value="24">腾退待租</option>--%>
                        <%--                            <option value="23">欠费</option>--%>
                        <%--                            <option value="27">其他</option>--%>
                        <%--                        </select>--%>

                        <div style="float: right;">
                            <input type="text" id="searchKeyword" name="searchKeyword" value="${searchKeyword}"
                                   class="ui_input_txt02" style="width: available ;"
                                   onclick="blueAllSearchKeyword()"/>
                            <input type="button" value="查询" class="ui_input_btn01" onclick="search();"/>
                            <input type="button" value="新增" class="ui_input_btn01" id="addBtn"/>
                            <input type="button" value="删除" class="ui_input_btn01" onclick="batchDel();"/>
                            <%--                        <input type="button" value="导入" class="ui_input_btn01" id="importBtn"/>--%>
                            <input type="button" value="导出" class="ui_input_btn01" onclick="exportExcel();"/>
                        </div>
                    </div>
                    <div id="box_bottom">
                        <label><input type="checkbox" onclick="checkboxFunction(this.id)" id="XINMIN">姓名</label>
                        <label><input type="checkbox" onclick="checkboxFunction(this.id)" id="SHENRI">生日</label>
                        <label><input type="checkbox" onclick="checkboxFunction(this.id)" id="JIGUAN">籍贯</label>
                        <label><input type="checkbox" onclick="checkboxFunction(this.id)" id="XUELI">学历</label>
                        <label><input type="checkbox" onclick="checkboxFunction(this.id)" id="BIYEYUANXIAO">毕业院校</label>
                        <label><input type="checkbox" onclick="checkboxFunction(this.id)"
                                      id="GONGZUONIANYUE">工作年月</label>
                        <label><input type="checkbox" onclick="checkboxFunction(this.id)" id="ZHIWU">职务</label>
                        <label><input type="checkbox" onclick="checkboxFunction(this.id)" id="ZHICHEN">职称</label>
                        <label><input type="checkbox" onclick="checkboxFunction(this.id)" id="JISHUZHIWU">技术职务</label>
                        <label><input type="checkbox" onclick="checkboxFunction(this.id)"
                                      id="ZHENZHIMIANMAO">政治面貌</label>
                        <label><input type="checkbox" onclick="checkboxFunction(this.id)" id="JIATINZHUZHI">家庭住址</label>
                        <label><input type="checkbox" onclick="checkboxFunction(this.id)" id="SHOUJI">手机</label>
                        <label><input type="checkbox" onclick="checkboxFunction(this.id)" id="ZHAIDIAN">宅电</label>

                    </div>
                </div>
            </div>
        </div>

        <div class="ui_content">
            <div class="ui_tb">
                <table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
                    <tr>
                        <th class="CHECKBOXALL" hidden="true" width="30"><input type="checkbox" class="all"
                                                                                onclick="selectOrClearAllCheckbox(this);"/>
                        </th>
 版本
                        <th class="JIGUAN" hidden="true">籍贯</th>
                        <th class="XUELI" hidden="true">学历</th>
                        <th class="BIYEYUANXIAO" hidden="true">毕业院校</th>
                        <th class="GONGZUONIANYUE" hidden="true">工作年月</th>
                        <th class="ZHIWU" hidden="true">职务</th>
                        <th class="ZHICHEN" hidden="true">职称</th>
                        <th class="JISHUZHIWU" hidden="true">技术职务</th>
                        <th class="ZHENZHIMIANMAO" hidden="true">政治面貌</th>
                        <th class="JIATINZHUZHI" hidden="true">家庭住址</th>
                        <th class="SHOUJI" hidden="true">手机</th>
                        <th class="ZHAIDIAN" hidden="true">宅电</th>
                        <th class="ZHIZHAOTYPE" hidden="true">执照</th>
                        <th class="ZHIZHAODATEFROM" hidden="true">获得时间</th>
                        <th class="ZHIZHAODATETO" hidden="true">到期时间</th>
                        <th class="CARCHEPAI" hidden="true">车牌号</th>
                        <th class="CARDENJIDATE" hidden="true">登记时间</th>
                        <th class="CHILDXINMIN" hidden="true">子女姓名</th>
                        <th class="CHILDXINBIE" hidden="true">子女性别</th>
                        <th class="CHILDSHENRI" hidden="true">子女出生日期</th>
                        <th class="CAOZUO" hidden="true">操作</th>

                    </tr>
                    <s:iterator value="personalList" id="a" status="st">
                        <tr>
                            <td class="CHECKBOXALL" hidden="true"><input type="checkbox" name="IDCheck" class="acb"/>
                            </td>
                            <td class="XINMIN" hidden="true"><s:property value="#a.XINMIN"/></td>
                            <td class="SHENRI" hidden="true"><s:date name="#a.SHENRI" format="yyyy-MM-dd"/></td>
                            <td class="JIGUAN" hidden="true"><s:property value="#a.JIGUAN"/></td>
                            <td class="XUELI" hidden="true"><s:property value="#a.XUELI"/></td>
                            <td class="BIYEYUANXIAO" hidden="true"><s:property value="#a.BIYEYUANXIAO"/></td>
                            <td class="GONGZUONIANYUE" hidden="true"><s:date name="#a.GONGZUONIANYUE" format="yyyy-MM-dd"/></td>
                            <td class="ZHIWU" hidden="true"><s:property value="#a.ZHIWU"/></td>
                            <td class="ZHICHEN" hidden="true"><s:property value="#a.ZHICHEN"/></td>
                            <td class="JISHUZHIWU" hidden="true"><s:property value="#a.JISHUZHIWU"/></td>
                            <td class="ZHENZHIMIANMAO" hidden="true"><s:property value="#a.ZHENZHIMIANMAO"/></td>
                            <td class="JIATINZHUZHI" hidden="true"><s:property value="#a.JIATINZHUZHI"/></td>
                            <td class="SHOUJI" hidden="true"><s:property value="#a.SHOUJI"/></td>
                            <td class="ZHAIDIAN" hidden="true"><s:property value="#a.ZHAIDIAN"/></td>

                            <td class="ZHIZHAOTYPE" hidden="true"><s:property value="#a.ZHIZHAO.ZHIZHAOTYPE"/></td>
                            <td class="ZHIZHAODATEFROM" hidden="true"><s:property
                                    value="#a.ZHIZHAO.ZHIZHAODATEFROM"/></td>
                            <td class="ZHIZHAODATETO" hidden="true"><s:property value="#a.ZHIZHAO.ZHIZHAODATETO"/></td>
                            <td class="CARCHEPAI" hidden="true"><s:property value="#a.CAR.CARCHEPAI"/></td>
                            <td class="CARDENJIDATE" hidden="true"><s:property value="#a.CAR.CARDENJIDATE"/></td>
                            <td class="CHILDXINMIN" hidden="true"><s:property value="#a.CHILD.CHILDXINMIN"/></td>
                            <td class="CHILDXINBIE" hidden="true"><s:property value="#a.CHILD.CHILDXINBIE"/></td>
                            <td class="CHILDSHENRI" hidden="true"><s:property value="#a.CHILD.CHILDSHENRI"/></td>

                            <td class="CAOZUO" hidden="true">
                                <a href="personalEditLoad.action?pid=<s:property value="#a.PID"/>" class="edit">编辑</a>
                                <a href="javascript:del('14458579642011');">删除</a>
                            </td>
                        </tr>

                    </s:iterator>

                </table>
            </div>
            <div class="ui_tb_h30">
                <div class="ui_flt" style="height: 30px; line-height: 30px;">
                    共有
                    <span class="ui_txt_bold04">90</span>
                    条记录，当前第
                    <span class="ui_txt_bold04">1
						/
						9</span>
                    页
                </div>
                <div class="ui_frt">
                    <!--    如果是第一页，则只显示下一页、尾页 -->

                    <input type="button" value="首页" class="ui_input_btn01"/>
                    <input type="button" value="上一页" class="ui_input_btn01"/>
                    <input type="button" value="下一页" class="ui_input_btn01"
                           onclick="jumpNormalPage(2);"/>
                    <input type="button" value="尾页" class="ui_input_btn01"
                           onclick="jumpNormalPage(9);"/>


                    <!--     如果是最后一页，则只显示首页、上一页 -->

                    转到第<input type="text" id="jumpNumTxt" class="ui_input_txt01"/>页
                    <input type="button" class="ui_input_btn01" value="跳转" onclick="jumpInputPage(9);"/>
                </div>
            </div>
        </div>
    </div>
</form>

</body>
</html>
