<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>管理员后台</title>
    <link rel="stylesheet" href="${ctx}/css/pintuer.css">
    <link rel="stylesheet" href="${ctx}/css/admin.css">
    <script src="${ctx}/js/jquery.js"></script>
    <script src="${ctx}/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="padding border-bottom">
        <ul class="search" style="padding-left: 10px;">
            <li>
                <a class="button border-main icon-plus-square-o" href="${ctx}/shoppingCategory/addCategory.action">新增类目</a>
            </li>
        </ul>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <th>ID</th>
            <th>类别名称</th>
            <th>操作</th>
        </tr>
    <c:forEach items="${pagers.datas}" var="data" varStatus="l">
        <tr>
            <td>${data.id}</td>
            <td>${data.name}</td>
            <td>
                <div class="button-group">
                    <a class="button border-main" href="${ctx}/shoppingCategory/findCategory.action?pid=${data.id}"><span class="icon-edit">查看二级分类</span> </a>
                    <a class="button border-main" href="${ctx}/shoppingCategory/update.action?id=${data.id}"><span class="icon-edit">修改</span> </a>
                    <a class="button border-red" href="${ctx}/shoppingCategory/delete.action?id=${data.id}"><span class="icon-trash-o">删除</span> </a>
                </div>
            </td>
        </tr>
    </c:forEach>
        <tr>
            <td colspan="8">
                <div class="pagelist">
                    <!--分页开始-->
                    <pg:pager url="${ctx}/shoppingCategory/findCategory.action" maxIndexPages="5" items="${pagers.total}" maxPageItems="15" export="curPage=pageNumber">
                        <pg:last>
                            共${pagers.total}记录，共${pageNumber}页，
                        </pg:last>
                        当前第${curPage}页
                        <pg:first>
                            <a href="${pageUrl}">首页</a>
                        </pg:first>
                        <pg:prev>
                            <a href="${pageUrl}">上一页</a>
                        </pg:prev>
                        <pg:pages>
                            <c:choose>
                                <c:when test="${curPage eq pageNumber}">
                                    <font color="red">[${pageNumber}]</font>
                                </c:when>
                                <c:otherwise>
                                    <a href="${pageUrl}">${pageNumber}</a>
                                </c:otherwise>
                            </c:choose>
                        </pg:pages>
                        <pg:next>
                            <a href="${pageUrl}">下一页</a>
                        </pg:next>
                        <pg:last>
                            <c:choose>
                                <c:when test="${curPage eq pageNumber}">
                                    <font color="red">尾页</font>
                                </c:when>
                                <c:otherwise>
                                    <a href="${pageUrl}">尾页</a>
                                </c:otherwise>
                            </c:choose>
                        </pg:last>
                    </pg:pager>
                </div>
            </td>
        </tr>
    </table>
</div>
</body>


<%--<script type="text/javascript">--%>
<%--    function ajaxsplit(page) {--%>
<%--        //异步ajax分页请求--%>
<%--        $.ajax({--%>
<%--            url:"${pageContext.request.contextPath}/prod/ajaxSplit.action",--%>
<%--            data:{"page":page},--%>
<%--            type:"post",--%>
<%--            success:function () {--%>
<%--                //重新加载分页显示的组件table--%>
<%--                //location.href---->http://localhost:8080/admin/login.action--%>
<%--                $("#table").load("http://localhost:8080/admin/product.jsp #table");--%>
<%--            }--%>
<%--        })--%>
<%--    };--%>

<%--</script>--%>

</html>