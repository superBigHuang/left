<template>
  <div>
    <el-row>
      <el-menu
          mode="horizontal" :default-active="activeIndex">
        <el-col :span="6">
          <el-menu-item index="1" style="color: blue;font-size: large"><i class="el-icon-back"></i>最左</el-menu-item>
        </el-col>
        <el-col :span="6">
          <el-row>
            <el-col :span="8">
              <el-menu-item index="2">关注</el-menu-item>
            </el-col>
            <el-col :span="8">
              <el-menu-item index="3">话题</el-menu-item>
            </el-col>
            <el-col :span="8">
              <el-menu-item index="4">推荐</el-menu-item>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="6">
          <el-input
              placeholder="请输入内容"
              v-model="input10"
              prefix-icon="el-icon-search"
              clearable
              style="margin-top: 9px"
              class="main-font">
          </el-input>
        </el-col>
        <el-col :span="6">
          <el-submenu index="5">
            <template slot="title">我的工作台</template>
            <el-menu-item index="5-1">选项1</el-menu-item>
            <el-menu-item index="5-2">选项2</el-menu-item>
            <el-menu-item index="5-3">选项3</el-menu-item>
          </el-submenu>
        </el-col>
      </el-menu>
    </el-row>
    <el-card class="box-card main-font" style="margin-top: 20px;width: 80%">
      <div class="flex_center" style="margin-bottom: 30px">
        <div class="head_content_flex">
          <div>
            请选择话题
          </div>
        </div>
        <div class="grid-content bg-purple">
          <el-autocomplete
              class="inline-input"
              v-model="state1"
              :fetch-suggestions="querySearch"
              placeholder="请输入内容"
              @select="handleSelect"
          ></el-autocomplete>
        </div>
      </div>

      <el-input
          type="textarea"
          :autosize="{ minRows: 6, maxRows: 12}"
          placeholder="请输入内容"
          v-model="textarea3"
          style="margin-bottom: 30px">
      </el-input>
      <el-row>
        <el-col :span="18" align="left">
          <el-upload
              action="https://jsonplaceholder.typicode.com/posts/"
              list-type="picture-card"
              :on-preview="handlePictureCardPreview"
              :on-remove="handleRemove">
            <i class="el-icon-plus"></i>
          </el-upload>
          <el-dialog :visible.sync="dialogVisible" size="tiny">
            <img width="100%" :src="dialogImageUrl" alt="">
          </el-dialog>
        </el-col>
        <el-col :span="6" align="right">
          <el-button type="primary" style="margin-top: 30% ">提交</el-button>
        </el-col>
      </el-row>

    </el-card>

  </div>

</template>

<script>
export default {
  name: "LeftInput",
  data() {
    return {
      textarea3: '',
      dialogImageUrl: '',
      dialogVisible: false,
      state1: '',
    }
  },
  methods: {
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    querySearch(queryString, cb) {
      var restaurants = this.restaurants;
      var results = queryString ? restaurants.filter(this.createFilter(queryString)) : restaurants;
      // 调用 callback 返回建议列表的数据
      cb(results);
    },
    createFilter(queryString) {
      return (restaurant) => {
        return (restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
      };
    },
    loadAll() {
      return [
        { "value": "香宜度麻辣香锅", "address": "长宁区淞虹路148号" },
        { "value": "凡仔汉堡（老真北路店）", "address": "上海市普陀区老真北路160号" },
        { "value": "港式小铺", "address": "上海市长宁区金钟路968号15楼15-105室" },
        { "value": "蜀香源麻辣香锅（剑河路店）", "address": "剑河路443-1" },
        { "value": "北京饺子馆", "address": "长宁区北新泾街道天山西路490-1号" },
        { "value": "饭典*新简餐（凌空SOHO店）", "address": "上海市长宁区金钟路968号9号楼地下一层9-83室" },
        { "value": "焦耳·川式快餐（金钟路店）", "address": "上海市金钟路633号地下一层甲部" },
        { "value": "动力鸡车", "address": "长宁区仙霞西路299弄3号101B" },
        { "value": "浏阳蒸菜", "address": "天山西路430号" },
        { "value": "四海游龙（天山西路店）", "address": "上海市长宁区天山西路" },
        { "value": "樱花食堂（凌空店）", "address": "上海市长宁区金钟路968号15楼15-105室" },
        { "value": "壹分米客家传统调制米粉(天山店)", "address": "天山西路428号" },
        { "value": "福荣祥烧腊（平溪路店）", "address": "上海市长宁区协和路福泉路255弄57-73号" },
        { "value": "速记黄焖鸡米饭", "address": "上海市长宁区北新泾街道金钟路180号1层01号摊位" },
        { "value": "红辣椒麻辣烫", "address": "上海市长宁区天山西路492号" },
        { "value": "(小杨生煎)西郊百联餐厅", "address": "长宁区仙霞西路88号百联2楼" },
        { "value": "阳阳麻辣烫", "address": "天山西路389号" },
        { "value": "南拳妈妈龙虾盖浇饭", "address": "普陀区金沙江路1699号鑫乐惠美食广场A13" }
      ];
    },
    handleSelect(item) {
      console.log(item);
    }
  },
  mounted() {
    this.restaurants = this.loadAll();
  }
}
</script>

<style scoped>
.main-font {
  margin-left: 10%;
  margin-right: 10%;
  width: 80%;
}

.flex_center {
  display: flex;
  align-items: center;
  justify-content: space-between;
  flex-wrap: nowrap;
  flex-wrap: nowrap
}

.head_content_flex {
  display: flex;
  align-items: center
}
</style>