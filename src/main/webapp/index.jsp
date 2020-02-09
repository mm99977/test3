<%--
  Created by IntelliJ IDEA.
  User: mm
  Date: 2020/1/10
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ztree测试页面</title>

    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link href="zTree_v3/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="zTree_v3/js/jquery-1.4.4.min.js"></script>
    <script src="zTree_v3/js/jquery.ztree.all.min.js" type="text/javascript"></script>

</head>
<body>
<div>
    <div id="treeDemo" class="ztree">
    </div>
</div>

</body>
<script language="JavaScript">
    var zTreeObj;
    // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
    var setting = {};
    // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
    var zNodes = [{
        name: "test1",
        open: true,
        children: [
            { name: "test1_1" }, { name: "test1_2" }
        ]
    },
        {
            name: "test2",
            open: true,
            children: [
                { name: "test2_1" }, { name: "test2_2" }
            ]
        }
    ];


    $(document).ready(function() {
        zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        zTreeObj.expandAll(true);//展开树
    });
</script>
<label>提交</label>
</html>
