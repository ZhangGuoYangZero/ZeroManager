<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ZGY-Manager</title>
    <#include "common.ftl">
</head>
<body class="layui-layout-body layuimini-all">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header header">
        <div class="layui-logo">
            <a href="">
                <img src="images/logo.png" alt="logo">
                <h1>Manager</h1>
            </a>
        </div>
        <a>
            <div class="layuimini-tool"><i title="展开" class="fa fa-outdent" data-side-fold="1"></i></div>
        </a>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item mobile layui-hide-xs" lay-unselect>
                <a href="javascript:;" data-check-screen="full"><i class="fa fa-arrows-alt"></i></a>
            </li>
            <li class="layui-nav-item layuimini-setting">
                <#--      这个user 就是main里给的那个session 里面的转发对象-->
                <a href="javascript:;">${(user.realName)!""}</a>
                <dl class="layui-nav-child">
                    <dd>
                        <a href="javascript:;" data-iframe-tab="${ctx}/user/toSettingPage" data-title="基本资料"
                           data-icon="fa fa-gears">基本资料</a>
                    </dd>
                    <dd>
                        <a href="javascript:;" data-iframe-tab="${ctx}/user/toPasswordPage" data-title="修改密码"
                           data-icon="fa fa-gears">修改密码</a>
                    </dd>
                    <dd>
                        <a href="javascript:;" class="login-out">退出登录</a>
                    </dd>
                </dl>
            </li>
            <li class="layui-nav-item layuimini-select-bgcolor mobile layui-hide-xs" lay-unselect>
                <a href="javascript:;"></a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll layui-left-menu">
            <ul class="layui-nav layui-nav-tree layui-left-nav-tree layui-this" id="currency">
                <#if profile?seq_contains("100")>
                <li class="layui-nav-item">
                    <a href="javascript:;" class="layui-menu-tips"><i class="fa fa-street-view"></i><span
                                class="layui-left-nav"> 供货商</span> <span class="layui-nav-more"></span></a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-1"
                               data-tab="suppliers/index" target="_self"><i class="fa fa-tty"></i><span
                                        class="layui-left-nav"> 供货商目录</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-2"
                               data-tab="procure/index" target="_self"><i class="fa fa-ellipsis-h"></i><span
                                        class="layui-left-nav"> 缺货目录</span></a>
                        </dd>
                    </dl>
                </li>
                </#if>
                <#if profile?seq_contains("200")>
                <li class="layui-nav-item">
                    <a href="javascript:;" class="layui-menu-tips"><i class="fa fa-flag"></i><span
                                class="layui-left-nav"> 财务和仓库</span> <span class="layui-nav-more"></span></a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-3"
                               data-tab="procure/index1" target="_self"><i class="fa fa-exchange"></i><span
                                        class="layui-left-nav"> 缺货表</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-4"
                               data-tab="all/index" target="_self"><i class="fa fa-exchange"></i><span
                                        class="layui-left-nav"> 库存表</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-4"
                               data-tab="cost/index" target="_self"><i class="fa fa-exchange"></i><span
                                        class="layui-left-nav"> 财务表</span></a>
                        </dd>
                    </dl>
                </li>
                </#if>
                <#if profile?seq_contains("300")>
                <li class="layui-nav-item">
                    <a href="javascript:;" class="layui-menu-tips"><i class="fa fa-desktop"></i><span
                                class="layui-left-nav">人事管理</span> <span class="layui-nav-more"></span></a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-5"
                               data-tab="emp/index" target="_self"><i class="fa fa-user"></i><span
                                        class="layui-left-nav">总职员表</span></a>
                        </dd>
                    </dl>
                </li>
                </#if>

                <span class="layui-nav-bar" style="top: 201px; height: 0px; opacity: 0;"></span>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <div class="layui-tab" lay-filter="layuiminiTab" id="top_tabs_box">
            <ul class="layui-tab-title" id="top_tabs">
                <li class="layui-this" id="layuiminiHomeTabId" lay-id="welcome"><i class="fa fa-home"></i>
                    <span>首页</span></li>
            </ul>

            <ul class="layui-nav closeBox">
                <li class="layui-nav-item">
                    <a href="javascript:;"> <i class="fa fa-dot-circle-o"></i> 页面操作</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-page-close="other"><i class="fa fa-window-close"></i> 关闭其他</a>
                        </dd>
                        <dd><a href="javascript:;" data-page-close="all"><i class="fa fa-window-close-o"></i> 关闭全部</a>
                        </dd>
                    </dl>
                </li>
            </ul>
            <div class="layui-tab-content clildFrame">
                <div id="layuiminiHomeTabIframe" class="layui-tab-item layui-show">
                </div>
            </div>
        </div>
    </div>

</div>

<script type="text/javascript" src="${ctx}/js/main.js"></script>
</body>
</html>
