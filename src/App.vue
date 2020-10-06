<template class="bodyBg">
  <div id="app">
    <el-row>
      <el-menu
          mode="horizontal" @select="handleSelect" :default-active="activeIndex" router>
        <el-col :span="6">
          <el-menu-item index="1" style="color: blue;font-size: large" @click="open"><i class="el-icon-back"></i>最左</el-menu-item>
        </el-col>
        <el-col :span="6">
          <el-row>
            <el-col :span="8"><el-menu-item index="/index" >关注</el-menu-item></el-col>
            <el-col :span="8"><el-menu-item index="/">话题</el-menu-item></el-col>
            <el-col :span="8"><el-menu-item index="/index">推荐</el-menu-item></el-col>
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
                  <el-badge class="mark" :value="3" />
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
    }
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    select() {
      console.log(this.input10)
      this.$router.push({path:"/search",query:{keyword:this.input10}})
    },
    open() {
      const h = this.$createElement;

      this.$notify({
        title: '关于',
        message: h('i', { style: 'color: teal'}, '本网站灵感来自于最右app')
      });
    },
  }

}
</script>

<style>

</style>
