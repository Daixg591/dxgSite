(window.webpackJsonp=window.webpackJsonp||[]).push([[45],{191:function(t,a,s){"use strict";s.r(a);var v=s(0),r=Object(v.a)({},(function(){var t=this.$createElement;this._self._c;return this._m(0)}),[function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("div",{staticClass:"content"},[s("h1",{attrs:{id:"组件通信"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#组件通信"}},[t._v("#")]),t._v(" 组件通信")]),t._v(" "),s("h5",{attrs:{id:"emit"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#emit"}},[t._v("#")]),t._v(" $emit")]),t._v(" "),s("blockquote",[s("p",[t._v("子向父通信")])]),t._v(" "),s("h5",{attrs:{id:"broadcast"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#broadcast"}},[t._v("#")]),t._v(" $broadcast")]),t._v(" "),s("blockquote",[s("p",[t._v("父向子通信")])]),t._v(" "),s("h5",{attrs:{id:"父子通信：父组件传递数据给子组件"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#父子通信：父组件传递数据给子组件"}},[t._v("#")]),t._v(" 父子通信：父组件传递数据给子组件")]),t._v(" "),s("p",[s("strong",[t._v("1、通过props传值")])]),t._v(" "),s("ol",[s("li",[t._v("如果需要传递动态属性值需要添加.sync修饰符")]),t._v(" "),s("li",[t._v("如果要在子组件中修改父组件数据需要在接受的时候添加 twoWay: true")]),t._v(" "),s("li",[t._v("如果需要数据双向绑定需要（.sync 和  twoWay 同时）")])]),t._v(" "),s("p",[s("strong",[t._v("2、实用$broadcast将数据广播到所有子组件中")])]),t._v(" "),s("h5",{attrs:{id:"子父通信：子组件传递数据给父组件"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#子父通信：子组件传递数据给父组件"}},[t._v("#")]),t._v(" 子父通信：子组件传递数据给父组件")]),t._v(" "),s("ol",[s("li",[t._v("在父组件中events中定义事件，在子组件$emit触发  （推荐）")]),t._v(" "),s("li",[t._v("在父组件methods中添加方法，在子组件中this.$invoke('../', '函数名称')")]),t._v(" "),s("li",[t._v("在子组件中通过this.$parent获取到父组件实例，调用父组件回调函数给父组件发送数据")])]),t._v(" "),s("h5",{attrs:{id:"同级：a、b两个同级组件的数据发送"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#同级：a、b两个同级组件的数据发送"}},[t._v("#")]),t._v(" 同级：A、B两个同级组件的数据发送")]),t._v(" "),s("ol",[s("li",[t._v("在A组件中通过this.$invoke('../B', '函数名称')  调用B组件中的回调函数传递数据")]),t._v(" "),s("li",[t._v("将数据发送到父组件，父组件在传递给另一个子组件（代理方式）")]),t._v(" "),s("li",[t._v("自己封装一个发布订阅器（eventbus）")])]),t._v(" "),s("h5",{attrs:{id:"跨级："}},[s("a",{staticClass:"header-anchor",attrs:{href:"#跨级："}},[t._v("#")]),t._v(" 跨级：")]),t._v(" "),s("ol",[s("li",[t._v("逐层传递")]),t._v(" "),s("li",[t._v("this.$invoke('组件路径', '函数名称')")])]),t._v(" "),s("p",[s("strong",[t._v("使用redux可以做所有的数据管理")])])])}],!1,null,null,null);a.default=r.exports}}]);