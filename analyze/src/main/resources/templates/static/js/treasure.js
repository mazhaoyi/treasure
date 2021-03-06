// 初始化页面
function initPage() {
    var today = new Date();
    $('#hiddenDate').val(today);
    $('#showDate').val(today.toLocaleDateString());
    $('#showType').val(3);
    $('#aft3But').css('background-color', '#0aa82f');
    createData(today, 3);
}
// 修改日期
function changeDay(day) {
    $('#zu3Num').val('0');
    $('#wxNum').val('0');
    var hiddenDate = $('#hiddenDate');
    if (hiddenDate.val() == null) {
        var today = new Date();
        $('#hiddenDate').val(today);
    }
    var pd = new Date(hiddenDate.val());
    pd.setDate(pd.getDate() + day);
    $('#hiddenDate').val(pd);
    $('#showDate').val(pd.toLocaleDateString());

    var showType = $('#showType').val();
    createData(pd, showType);
}
// 切换类型1-前三，2-中三，3-后三
function changeType(type, but) {
    $('#zu3Num').val('0');
    $('#wxNum').val('0');
    $(but).parent().children().css('background-color', '');
    $(but).css('background-color', '#0aa82f');
    $('#showType').val(type);
    var day = $('#hiddenDate').val();
    day = new Date(day);
    createData(day, type);
}

/**
 * 获取数据
 * @param date 日期
 * @param type 类型1-前三，2-中三，3-后三
 */
function createData(date, type) {
    date = date.toLocaleDateString();
    var u1 = $('#u1'), u2 = $('#u2'), u3 = $('#u3'), u4 = $('#u4'), u5 = $('#u5'), u6 = $('#u6');
    var ulHead = '';
    // 清空页面
    u1.html(ulHead);
    u2.html(ulHead);
    u3.html(ulHead);
    u4.html(ulHead);
    u5.html(ulHead);
    u6.html(ulHead);
    // 1-前三，2-中三，3-后三
    var befType = 1, midType = 2, aftType = 3, wqsType = 4, wqgType = 5, wbsType = 6, wbgType = 7, wsgType = 8, qbgType = 9, qsgType = 10;
    // 默认后三
    if (type == null) {
        type = 3;
    }
    $.ajax({
        type: 'GET',
        dataType: 'json',
        url: '/analyze/list',
        contentType: 'application/json;charset=utf-8',
        data: {'date':date},
        success: function (data) {
            if (data == null) {
                alert('没有响应结果！');
                return;
            }
            if (data.code != 200) {
                alert(data.message);
                return;
            }
            var datas = data.data;
            // 线形图列表数据
            var lineDatas = new Array();
            // 线性数据初始化数据
            var initLineData = 0;
            var subtitle = '';
            for (var i = 0; i < datas.length; i++) {
                var dt = datas[i];
                // 期号
                var no = dt.no;
                // 号码
                var num = dt.num;
                var li = '<li><span>' + no + '</span><span class="num_span">' + num + '</span></li>';
                // jquery li对象
                var jli = $(li);
                if (i >= 0 && i < 20) {
                    u1.append(jli);
                } else if (i >= 20 && i < 40) {
                    u2.append(jli);
                } else if (i >= 40 && i < 60) {
                    u3.append(jli);
                } else if (i >= 60 && i < 80) {
                    u4.append(jli);
                } else if (i >= 80 && i < 100) {
                    u5.append(jli);
                } else if (i >= 100 && i < 120) {
                    u6.append(jli);
                }
                // 每期金钱
                var oneMoney = 1;
                // 前三
                if (type == befType) {
                    // 前三最大相同个数
                    var bef3MaxCount = dt.bef3MaxCount;
                    // 前三012路
                    var bef3012 = dt.bef3012;
                    if (bef3MaxCount == 2) {
                        initLineData = initLineData - oneMoney + oneMoney*3.23/0.9;
                        lineDatas[i] = parseFloat(initLineData.toFixed(2));
                    } else if (bef3MaxCount == 1 || bef3MaxCount == 3) {
                        initLineData = initLineData - oneMoney;
                        lineDatas[i] = parseFloat(initLineData.toFixed(2));
                    }
                    subtitle = '前三';
                    createZu3(jli, bef3MaxCount, bef3012);
                    // 中三
                } else if (type == midType) {
                    // 中三最大相同个数
                    var mid3MaxCount = dt.mid3MaxCount;
                    // 中三012路
                    var mid3012 = dt.mid3012;
                    if (mid3MaxCount == 2) {
                        initLineData = initLineData - oneMoney + oneMoney*3.23/0.9;
                        lineDatas[i] = parseFloat(initLineData.toFixed(2));
                    } else if (mid3MaxCount == 1 || mid3MaxCount == 3) {
                        initLineData = initLineData - oneMoney;
                        lineDatas[i] = parseFloat(initLineData.toFixed(2));
                    }
                    subtitle = '中三';
                    createZu3(jli, mid3MaxCount, mid3012);
                    // 后三
                } else if (type == aftType) {
                    // 后三最大相同个数
                    var aft3MaxCount = dt.aft3MaxCount;
                    // 后三012路
                    var aft3012 = dt.aft3012;
                    if (aft3MaxCount == 2) {
                        initLineData = initLineData - oneMoney + oneMoney*3.23/0.9;
                        lineDatas[i] = parseFloat(initLineData.toFixed(2));
                    } else if (aft3MaxCount == 1 || aft3MaxCount == 3) {
                        initLineData = initLineData - oneMoney;
                        lineDatas[i] = parseFloat(initLineData.toFixed(2));
                    }
                    subtitle = '后三';
                    createZu3(jli, aft3MaxCount, aft3012);
                    // 万千十
                } else if (type == wqsType) {
                    // 万千十大相同个数
                    var wqsMaxCount = dt.wqsMaxCount;
                    // 万千十012路
                    var wqs012 = dt.wqs012;
                    if (wqsMaxCount == 2) {
                        initLineData = initLineData - oneMoney + oneMoney*3.23/0.9;
                        lineDatas[i] = parseFloat(initLineData.toFixed(2));
                    } else if (wqsMaxCount == 1 || wqsMaxCount == 3) {
                        initLineData = initLineData - oneMoney;
                        lineDatas[i] = parseFloat(initLineData.toFixed(2));
                    }
                    subtitle = '万千十';
                    createZu3(jli, wqsMaxCount, wqs012);
                    // 万千个
                } else if (type == wqgType) {
                    // 万千个大相同个数
                    var wqgMaxCount = dt.wqgMaxCount;
                    // 万千个012路
                    var wqg012 = dt.wqg012;
                    if (wqgMaxCount == 2) {
                        initLineData = initLineData - oneMoney + oneMoney*3.23/0.9;
                        lineDatas[i] = parseFloat(initLineData.toFixed(2));
                    } else if (wqgMaxCount == 1 || wqgMaxCount == 3) {
                        initLineData = initLineData - oneMoney;
                        lineDatas[i] = parseFloat(initLineData.toFixed(2));
                    }
                    subtitle = '万千个';
                    createZu3(jli, wqgMaxCount, wqg012);
                    // 万百十
                } else if (type == wbsType) {
                    // 万百十大相同个数
                    var wbsMaxCount = dt.wbsMaxCount;
                    // 万百十012路
                    var wbs012 = dt.wbs012;
                    if (wbsMaxCount == 2) {
                        initLineData = initLineData - oneMoney + oneMoney*3.23/0.9;
                        lineDatas[i] = parseFloat(initLineData.toFixed(2));
                    } else if (wbsMaxCount == 1 || wbsMaxCount == 3) {
                        initLineData = initLineData - oneMoney;
                        lineDatas[i] = parseFloat(initLineData.toFixed(2));
                    }
                    subtitle = '万百十';
                    createZu3(jli, wbsMaxCount, wbs012);
                    // 万百个
                } else if (type == wbgType) {
                    // 万百个大相同个数
                    var wbgMaxCount = dt.wbgMaxCount;
                    // 万百个012路
                    var wbg012 = dt.wbg012;
                    if (wbgMaxCount == 2) {
                        initLineData = initLineData - oneMoney + oneMoney*3.23/0.9;
                        lineDatas[i] = parseFloat(initLineData.toFixed(2));
                    } else if (wbgMaxCount == 1 || wbgMaxCount == 3) {
                        initLineData = initLineData - oneMoney;
                        lineDatas[i] = parseFloat(initLineData.toFixed(2));
                    }
                    subtitle = '万百个';
                    createZu3(jli, wbgMaxCount, wbg012);
                    // 万十个
                } else if (type == wsgType) {
                    // 万十个大相同个数
                    var wsgMaxCount = dt.wsgMaxCount;
                    // 万十个012路
                    var wsg012 = dt.wsg012;
                    if (wsgMaxCount == 2) {
                        initLineData = initLineData - oneMoney + oneMoney*3.23/0.9;
                        lineDatas[i] = parseFloat(initLineData.toFixed(2));
                    } else if (wsgMaxCount == 1 || wsgMaxCount == 3) {
                        initLineData = initLineData - oneMoney;
                        lineDatas[i] = parseFloat(initLineData.toFixed(2));
                    }
                    subtitle = '万十个';
                    createZu3(jli, wsgMaxCount, wsg012);
                    // 千百个
                } else if (type == qbgType) {
                    // 千百个大相同个数
                    var qbgMaxCount = dt.qbgMaxCount;
                    // 千百个012路
                    var qbg012 = dt.qbg012;
                    if (qbgMaxCount == 2) {
                        initLineData = initLineData - oneMoney + oneMoney*3.23/0.9;
                        lineDatas[i] = parseFloat(initLineData.toFixed(2));
                    } else if (qbgMaxCount == 1 || qbgMaxCount == 3) {
                        initLineData = initLineData - oneMoney;
                        lineDatas[i] = parseFloat(initLineData.toFixed(2));
                    }
                    subtitle = '千百个';
                    createZu3(jli, qbgMaxCount, qbg012);
                    // 千十个
                } else if (type == qsgType) {
                    // 千十个大相同个数
                    var qsgMaxCount = dt.qsgMaxCount;
                    // 千十个012路
                    var qsg012 = dt.qsg012;
                    if (qsgMaxCount == 2) {
                        initLineData = initLineData - oneMoney + oneMoney*3.23/0.9;
                        lineDatas[i] = parseFloat(initLineData.toFixed(2));
                    } else if (qsgMaxCount == 1 || qsgMaxCount == 3) {
                        initLineData = initLineData - oneMoney;
                        lineDatas[i] = parseFloat(initLineData.toFixed(2));
                    }
                    subtitle = '千十个';
                    createZu3(jli, qsgMaxCount, qsg012);
                }

                var wxz5 = dt.wxz5, wxz10 = dt.wxz10, wxz20 = dt.wxz20, wxz30 = dt.wxz30;
                // 组5，组10，组20，组30
                if (num.trim() != '') {
                    createWx(jli, wxz5, wxz10, wxz20, wxz30);
                }

            }
            lineChart(subtitle, lineDatas);
        }
    });
}

/**
 * 012路，组3渲染
 * @param li jQuery对象
 * @param maxCount 最大重复数
 * @param if012 是否012路
 */
function createZu3(li, maxCount, if012) {
    var zu3Num = $('#zu3Num').val();
    var span = null;
    // 组装span
    if (maxCount == 2) {
        span = '<span style="color: red;">组三</span>';
        $('#zu3Num').val(0);
    } else if (maxCount == 1) {
        zu3Num++;
        span = '<span>' + zu3Num + '</span>';
        $('#zu3Num').val(zu3Num);
    } else if (maxCount == 3) {
        $('#zu3Num').val(0);
        span = '<span style="color: #5865ff;">豹子</span>';
    }
    // span放到li下面
    li.append(span);
    // 012路
    if (if012) {
        li.append('<span style="color: #2db69d;">012</span>');
    } else {
        if (maxCount > 0) {
            li.append('<span style="color: #f0f6ff;">012</span>');
        }
    }
}

/**
 * 五星组5，组10，组20，组30渲染
 * @param wxz5 是否组5
 * @param wxz10 是否组10
 * @param wxz20 是否组20
 * @param wxz30 是否组30
 */
function createWx(li, wxz5, wxz10, wxz20, wxz30) {
    var wxNum = $('#wxNum').val();
    var val = '';
    var color = '#5865ff';
    if (wxz5) {
        $('#wxNum').val(0);
        val = '组5';
    } else if (wxz10) {
        $('#wxNum').val(0);
        val = '组10';
    } else if (wxz20) {
        $('#wxNum').val(0);
        val = '组20';
    } else if (wxz30) {
        $('#wxNum').val(0);
        val = '组30';
        color = 'red';
    } else {
        wxNum++;
        $('#wxNum').val(wxNum);
        val = wxNum;
        color = '#8A98FF';
    }
    li.append('<span style="color: ' + color + ';">' + val + '</span>');
}

function lineChart(subtitle, datas) {
    var title = {
        text: '金钱线形图'
    };
    var subtitle = {
        text: subtitle
    };
    var xAxis = {
        categories: ["001","002","003","004","005","006","007","008","009","010","011","012","013","014","015","016","017","018","019","020","021","022","023","024","025","026","027","028","029","030","031","032","033","034","035","036","037","038","039","040","041","042","043","044","045","046","047","048","049","050","051","052","053","054","055","056","057","058","059","060","061","062","063","064","065","066","067","068","069","070","071","072","073","074","075","076","077","078","079","080","081","082","083","084","085","086","087","088","089","090","091","092","093","094","095","096","097","098","099","100","101","102","103","104","105","106","107","108","109","110","111","112","113","114","115","116","117","118","119","120"]
    };
    var yAxis = {
        title: {},
        plotLines:[{
            value: 0,
            width: 1,
            color: '#808080'
        }]
    };
    var tooltip = {
        valueSuffix: '元'
    }
    var legend = {
        layout: 'vertical',
        align: 'right',
        verticalAlign: 'middle',
        borderWidth: 0
    };
    var series =  [
        {
            name: '组三',
            data: datas
        }
    ];
    var plotOptions = {
        line: {
            dataLabels: {
                enabled: true
            },
            enableMouseTracking: true
        }
    };
    var json = {};
    json.title = title;
    json.subtitle = subtitle;
    json.xAxis = xAxis;
    json.yAxis = yAxis;
    json.tooltip = tooltip;
    json.legend = legend;
    json.series = series;
    json.plotOptions = plotOptions;
    $('#chartDiv').highcharts(json);
}