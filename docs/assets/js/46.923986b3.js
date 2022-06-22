(window.webpackJsonp=window.webpackJsonp||[]).push([[46],{192:function(a,t,n){"use strict";n.r(t);var e=n(0),s=Object(e.a)({},(function(){var a=this.$createElement;this._self._c;return this._m(0)}),[function(){var a=this,t=a.$createElement,n=a._self._c||t;return n("div",{staticClass:"content"},[n("h1",{attrs:{id:"小程序事件"}},[n("a",{staticClass:"header-anchor",attrs:{href:"#小程序事件"}},[a._v("#")]),a._v(" 小程序事件")]),a._v(" "),n("h5",{attrs:{id:"事件"}},[n("a",{staticClass:"header-anchor",attrs:{href:"#事件"}},[a._v("#")]),a._v(" 事件")]),a._v(" "),n("ul",[n("li",[a._v("事件就是用户到界面（视图）的交互行为，移动端常见的交互行为（触屏，触摸移动，长按，键盘输入，多点触控，摇一摇，语音，各种状态事件，....， 重按）")])]),a._v(" "),n("h5",{attrs:{id:"事件绑定"}},[n("a",{staticClass:"header-anchor",attrs:{href:"#事件绑定"}},[a._v("#")]),a._v(" 事件绑定")]),a._v(" "),n("div",{staticClass:"language- extra-class"},[n("pre",{pre:!0,attrs:{class:"language-text"}},[n("code",[a._v("在小程序中绑定事件使用 bind不会阻止冒泡,  catch阻止冒泡  capture-bind使用捕获 capture-catch\n两种写法\nbind:tap   bindtap\ncatch:tap  catchtap\n\n例如: <view bindtap=”eventCallback”>点我</view> 当用户点击该组件的时候会在该页面对应的Page中找到相应的事件处理函数。在事件处理函数中会得到事件对象event\n\nPage(\n    eventCallback (event) {\n        Console.log(event)\n    }\n)\n\nEvent对象\n\n{\n    //基础属性\n    Type: 事件类型,\n    timeStamp: 事件生成时的时间戳\n    Target: {\n    Id: ,事件源组件的id\n    tagName: ,  \t当前组件的类型\n    Dataset:  事件源组件上由data-开头的自定义属性组成的集合 (可用作事件传参)\n    }  触发事件的组件的一些属性值集合\n    currentTarget: 当前组件的一些属性值集合,\n    \n    detail: 额外信息  {x, y}   触摸点的位置\n    \n    //触控信息\n    Touches: 手指头列表\n    changenTouches: 动了的手指头的列表\n}\n")])])]),n("h5",{attrs:{id:"事件分类"}},[n("a",{staticClass:"header-anchor",attrs:{href:"#事件分类"}},[a._v("#")]),a._v(" 事件分类")]),a._v(" "),n("ul",[n("li",[a._v("事件分为冒泡事件和非冒泡事件\n"),n("ol",[n("li",[a._v("冒泡事件：当一个组件上的事件被触发后，该事件会向父节点传递。")]),a._v(" "),n("li",[a._v("非冒泡事件：当一个组件上的事件被触发后，该事件不会向父节点传递。(例如：表单相关事件，加载相关事件)")])])])]),a._v(" "),n("h5",{attrs:{id:"交互事件"}},[n("a",{staticClass:"header-anchor",attrs:{href:"#交互事件"}},[a._v("#")]),a._v(" 交互事件")]),a._v(" "),n("div",{staticClass:"language- extra-class"},[n("pre",{pre:!0,attrs:{class:"language-text"}},[n("code",[a._v("触摸 touchstart\n移动 touchmove\n打断 touchcancel\n离开 touchend\n轻触 tap\n长按（超过350毫秒） longtab    longpress\n重按（3D Touch设备） touchforcechange\n")])])]),n("h5",{attrs:{id:"监听事件"}},[n("a",{staticClass:"header-anchor",attrs:{href:"#监听事件"}},[a._v("#")]),a._v(" 监听事件")]),a._v(" "),n("div",{staticClass:"language- extra-class"},[n("pre",{pre:!0,attrs:{class:"language-text"}},[n("code",[a._v("transitionend       会在 WXSS transition 或 wx.createAnimation 动画结束后触发\nanimationstart      会在一个 WXSS animation 动画开始时触发\nanimationiteration   会在一个 WXSS animation 一次迭代结束时触发\nanimationend       会在一个 WXSS animation 动画完成时触发\n\n")])])])])}],!1,null,null,null);t.default=s.exports}}]);