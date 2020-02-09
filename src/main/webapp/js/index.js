
var zNodes = [{
    name: "父节点1 - 展开",
    open: true,
    children: [{
        name: "父节点11 - 折叠",
        children: [{
            name: "叶子节点111"
        },
            {
                name: "叶子节点112"
            }]
    },
        {
            name: "父节点12 - 折叠",
            children: [{
                name: "叶子节点121"
            },
                {
                    name: "叶子节点122"
                }]
        },
        {
            name: "父节点13 - 没有子节点",
            isParent: true
        }]
},
    {
        name: "父节点2 - 折叠",
        children: [{
            name: "父节点21 - 展开",
            open: true,
            children: [{
                name: "叶子节点211"
            },
                {
                    name: "叶子节点212"
                }]
        },
            {
                name: "父节点22 - 折叠",
                children: [{
                    name: "叶子节点221"
                },
                    {
                        name: "叶子节点222"
                    }]
            },
            {
                name: "父节点23 - 折叠",
                children: [{
                    name: "叶子节点231"
                }]
            }]
    },
    {
        name: "父节点3 - 没有子节点",
        isParent: true
    }
];
/*演示三：自定义图标 -- icon 属性*/
var setting = {
    data: {
        simpleData: {
            enable: true
        }
    }
};

var zNodes =[
    { id:1, pId:0, name:"展开、折叠 自定义图标不同", open:true, iconOpen:"../css/zTreeStyle/img/diy/1_open.png", iconClose:"../css/zTreeStyle/img/diy/1_close.png"},
    { id:11, pId:1, name:"叶子节点1", icon:"../css/zTreeStyle/img/diy/2.png"},
    { id:2, pId:0, name:"展开、折叠 自定义图标相同", open:true, icon:"../css/zTreeStyle/img/diy/4.png"},
    { id:21, pId:2, name:"叶子节点1", icon:"../css/zTreeStyle/img/diy/6.png"},
    { id:3, pId:0, name:"不使用自定义图标", open:true },
    { id:31, pId:3, name:"叶子节点1"}
];

$(document).ready(function(){
    $.fn.zTree.init($("#treeDemo"), setting, zNodes);
});
/*演示三：异步加载节点数据的树*/
var setting = {
    async: {
        enable: true,
        url: "../asyncData/getNodes.php",
        autoParam: ["id", "name=n", "level=lv"],
        otherParam: {
            "otherParam": "zTreeAsyncTest"
        },
        dataFilter: filter
    }
};

function filter(treeId, parentNode, childNodes) {
    if (!childNodes) return null;
    for (var i = 0,
             l = childNodes.length; i < l; i++) {
        childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
    }
    return childNodes;
}

$(document).ready(function() {
    $.fn.zTree.init($("#treeDemo"), setting);
});
/*演示四：单击节点控制*/
var setting = {
    data: {
        key: {
            title: "t"
        },
        simpleData: {
            enable: true
        }
    },
    callback: {
        beforeClick: beforeClick,
        onClick: onClick
    }
};

var zNodes = [{
    id: 1,
    pId: 0,
    name: "普通的父节点",
    t: "我很普通，随便点我吧",
    open: true
},
    {
        id: 11,
        pId: 1,
        name: "叶子节点 - 1",
        t: "我很普通，随便点我吧"
    },
    {
        id: 12,
        pId: 1,
        name: "叶子节点 - 2",
        t: "我很普通，随便点我吧"
    },
    {
        id: 13,
        pId: 1,
        name: "叶子节点 - 3",
        t: "我很普通，随便点我吧"
    },
    {
        id: 2,
        pId: 0,
        name: "NB的父节点",
        t: "点我可以，但是不能点我的子节点，有本事点一个你试试看？",
        open: true
    },
    {
        id: 21,
        pId: 2,
        name: "叶子节点2 - 1",
        t: "你哪个单位的？敢随便点我？小心点儿..",
        click: false
    },
    {
        id: 22,
        pId: 2,
        name: "叶子节点2 - 2",
        t: "我有老爸罩着呢，点击我的小心点儿..",
        click: false
    },
    {
        id: 23,
        pId: 2,
        name: "叶子节点2 - 3",
        t: "好歹我也是个领导，别普通群众就来点击我..",
        click: false
    },
    {
        id: 3,
        pId: 0,
        name: "郁闷的父节点",
        t: "别点我，我好害怕...我的子节点随便点吧...",
        open: true,
        click: false
    },
    {
        id: 31,
        pId: 3,
        name: "叶子节点3 - 1",
        t: "唉，随便点我吧"
    },
    {
        id: 32,
        pId: 3,
        name: "叶子节点3 - 2",
        t: "唉，随便点我吧"
    },
    {
        id: 33,
        pId: 3,
        name: "叶子节点3 - 3",
        t: "唉，随便点我吧"
    }];

var log, className = "dark";
function beforeClick(treeId, treeNode, clickFlag) {
    className = (className === "dark" ? "": "dark");
    showLog("[ " + getTime() + " beforeClick ]  " + treeNode.name);
    return (treeNode.click != false);
}
function onClick(event, treeId, treeNode, clickFlag) {
    showLog("[ " + getTime() + " onClick ]  clickFlag = " + clickFlag + " (" + (clickFlag === 1 ? "普通选中": (clickFlag === 0 ? "<b>取消选中</b>": "<b>追加选中</b>")) + ")");
}
function showLog(str) {
    if (!log) log = $("#log");
    log.append("<li class='" + className + "'>" + str + "</li>");
    if (log.children("li").length > 8) {
        log.get(0).removeChild(log.children("li")[0]);
    }
}
function getTime() {
    var now = new Date(),
        h = now.getHours(),
        m = now.getMinutes(),
        s = now.getSeconds();
    return (h + ":" + m + ":" + s);
}

$(document).ready(function() {
    $.fn.zTree.init($("#treeDemo"), setting, zNodes);
});