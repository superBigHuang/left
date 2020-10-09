import Vue from 'vue'
import App from "@/App";
import VueRouter from 'vue-router'
import LeftTopic from "@/views/LeftTopic";
import LeftIndex from "@/views/LeftIndex";
import LeftContent from "@/views/LeftContent";
import LeftSearch from "@/views/LeftSearch";
import LeftUserInfo from "@/views/LeftUserInfo";
import LeftLogin from "@/views/LeftLogin";
import LeftUserPanel from "@/views/LeftUserPanel";

Vue.use(VueRouter)

const routes = [
  {
    path: "/",
    component: LeftTopic,
    show: false
  },
  {
    path: "/index",
    component: LeftIndex,
    show: false
  },
  {
    path: "/content",
    component: LeftContent,
    show: false
  },
  {
    path: "/search",
    component: LeftSearch,
    show: false
  },
  {
    path: "/userInfo",
    component: LeftUserInfo,
    show: false
  },
  {
    path: "/login",
    component: LeftLogin,
    show: false
  },
  {
    path: "/panel",
    component: LeftUserPanel,
    show: false
  },

]

const router = new VueRouter({
  routes
})

export default router
