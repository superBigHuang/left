<template class="bodyBg">
  <div id="app">
    <link rel="stylesheet" href="//at.alicdn.com/t/font_2117702_vi2iknhluzs.css">
    <el-row>
      <el-menu
          mode="horizontal" @select="handleSelect" :default-active="activeIndex" router>
        <el-col :span="6">
          <el-menu-item index="1" style="color: blue;font-size: large" @click="open"><i class="iconfont iconbiaoda"></i>最左
          </el-menu-item>
        </el-col>
        <el-col :span="6">
          <el-row>
            <el-col :span="8">
              <el-menu-item index="/watch">关注</el-menu-item>
            </el-col>
            <el-col :span="8">
              <el-menu-item index="/topic">话题</el-menu-item>
            </el-col>
            <el-col :span="8">
              <el-menu-item index="/index">推荐</el-menu-item>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="6">
          <el-input
              @blur="select"
              placeholder="请输入内容"
              v-model="input10"
              prefix-icon="el-icon-search"
              clearable
              style="margin-top: 9px"
              class="main-font">
          </el-input>
        </el-col>
        <el-row type="flex" justify="end" align="middle">
          <el-col :span="6" style="margin-top: 13px">
            <el-dropdown>
            <span class="el-dropdown-link">
              我的工作台<i class="el-icon-arrow-down el-icon--right"></i>
            </span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item class="clearfix">
                  个人信息
                </el-dropdown-item>
                <el-dropdown-item class="clearfix">
                  回复
                  <el-badge class="mark" :value="3"/>
                </el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </el-col>
        </el-row>

      </el-menu>
    </el-row>

    <router-view class="bodyBg"></router-view>
  </div>
</template>

<script>
export default {
  name: 'app',
  data() {
    return {
      activeIndex: "/",
      input10: "",
      count: 0,
      about: [
        {
          title: "关于",
          message: "本网站灵感来自于最右app,不进行任何商业活动，仅进行大四学期的毕业设计，仅供学习"
        },
        {
          title: "开源说明",
          message: "本系统100%开源，遵守GPL-3.0协议"
        },
        {
          title: "github开源地址",
          message: "https://github.com/superBigHuang/left"
        },
        {
          title: "前端技术栈",
          message: "vue.js + Element UI"
        },
        {
          title: "后端技术栈",
          message: "spring boot + spring data jpa + spring data redis + spring security + swagger2"
        },
      ]
    }
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    select() {
      console.log(this.input10)
      this.$router.push({path: "/search", query: {keyword: this.input10}})
    },
    open() {

      const h = this.$createElement;
      this.$notify({
        title: this.about[this.count].title,
        message: h('i', {style: 'color: teal'}, this.about[this.count].message)
      });

      if (this.count < 5) {
        this.count++
      }
      if (this.count >= 5) {
        this.count = 0
      }
    },
  }

}
</script>

<style>

</style>
