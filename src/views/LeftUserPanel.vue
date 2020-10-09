<template>
  <div class="main-font">
    <link rel="stylesheet" href="//at.alicdn.com/t/font_2117702_1zvjf84gcazh.css">
    <el-container style="height: 80%; border: 1px solid #eee;margin-top: 30px">
      <el-aside width="230px">
        <el-menu  @select="handleSelect" :default-active="menuIndex">
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-edit"></i>我发布的</template>
            <el-menu-item-group>
              <el-menu-item index="1-1">评论</el-menu-item>
              <el-menu-item index="1-2">帖子</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-menu"></i>我的人</template>
            <el-menu-item-group>
              <el-menu-item index="2-1">我关注的</el-menu-item>
              <el-menu-item index="2-2">我的粉丝</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title"><i class="el-icon-setting"></i>设置</template>
            <el-menu-item-group>
              <el-menu-item index="3-1">修改用户信息</el-menu-item>
              <el-menu-item index="3-2">修改密码</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header style="text-align: right; font-size: 12px">
          <el-dropdown>
            <i class="el-icon-setting" style="margin-right: 15px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>查看</el-dropdown-item>
              <el-dropdown-item>新增</el-dropdown-item>
              <el-dropdown-item>删除</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <span>王小虎</span>
        </el-header>

        <el-main>
          <!--评论列表-->
          <el-table
              :data="tableData"
              style="width: 100%"
              :default-sort="{prop: 'date', order: 'descending'}"
              v-if="menuIndex == '1-1'"
          >
            <el-table-column
                prop="date"
                label="日期"
                sortable
                width="180">
            </el-table-column>
            <el-table-column
                prop="name"
                label="点赞数"
                sortable
                width="100">
            </el-table-column>
            <el-table-column
                prop="address"
                label="内容"
                :formatter="formatter">
            </el-table-column>
            <el-table-column label="操作" width="100">
              <template slot-scope="scope">
                <el-button
                    size="mini"
                    type="danger"
                    @click="handleDelete(scope.$index, scope.row)">删除
                </el-button>
              </template>
            </el-table-column>
          </el-table>
          <!--博客列表-->
          <el-table
              :data="tableData"
              style="width: 100%"
              :default-sort="{prop: 'date', order: 'descending'}"
              v-if="menuIndex == '1-2'"
          >
            <el-table-column
                prop="date"
                label="日期"
                sortable
                width="180">
            </el-table-column>
            <el-table-column
                prop="name"
                label="点赞数"
                sortable
                width="100">
            </el-table-column>
            <el-table-column
                prop="address"
                label="内容"
                :formatter="formatter">
            </el-table-column>
            <el-table-column label="操作" width="200">
              <template slot-scope="scope">
                <el-button
                    size="mini"
                    type="primary"
                    @click="handleDelete(scope.$index, scope.row)"
                    v-popover:popover1>
                  查看评论
                </el-button>
                <el-popover
                    ref="popover1"
                    placement="bottom"
                    width="200"
                    trigger="hover"
                    content="一共有9条评论">
                </el-popover>
                <el-button
                    size="mini"
                    type="danger"
                    @click="handleDelete(scope.$index, scope.row)">删除
                </el-button>
              </template>

            </el-table-column>
          </el-table>
          <!--关注列表-->
          <el-table
              :data="users"
              style="width: 100%"
              :default-sort="{prop: 'date', order: 'descending'}"
              v-if="menuIndex == '2-1'"
          >
            <el-table-column
                label="头像"
                width="50">
              <template slot-scope="scope">
                <img :src="scope.row.headImg" class="round-icon">
              </template>
            </el-table-column>
            <el-table-column
                label="名称"
                width="100">
              <template slot-scope="scope">
                <span style="padding-right: 20px">{{ scope.row.name }}</span>
                <i v-if="scope.row.sex==='male'" class="iconfont iconxingbie-nv"></i>
                <i v-if="scope.row.sex==='female'" class="iconfont iconxingbie-nan"></i>
              </template>
            </el-table-column>
            <el-table-column
                label="简介"
                :formatter="formatter">
              <template slot-scope="scope">
                <span style="padding-right: 20px">{{ scope.row.introduction }}</span>
              </template>
            </el-table-column>
            <el-table-column label="操作" width="120">
              <template slot-scope="scope">
                <el-button
                    size="mini"
                    type="danger"
                    @click="handleDelete(scope.$index, scope.row)">取消关注
                </el-button>
              </template>
            </el-table-column>
          </el-table>
          <!--粉丝列表-->
          <el-table
              :data="users"
              style="width: 100%"
              :default-sort="{prop: 'date', order: 'descending'}"
              v-if="menuIndex == '2-2'"
          >
            <el-table-column
                label="头像"
                width="50">
              <template slot-scope="scope">
                <img :src="scope.row.headImg" class="round-icon">
              </template>
            </el-table-column>
            <el-table-column
                label="名称"
                width="100">
              <template slot-scope="scope">
                <span style="padding-right: 20px">{{ scope.row.name }}</span>
                <i v-if="scope.row.sex==='male'" class="iconfont iconxingbie-nv"></i>
                <i v-if="scope.row.sex==='female'" class="iconfont iconxingbie-nan"></i>
              </template>
            </el-table-column>
            <el-table-column
                label="简介"
                :formatter="formatter">
              <template slot-scope="scope">
                <span style="padding-right: 20px">{{ scope.row.introduction }}</span>
              </template>
            </el-table-column>
            <el-table-column label="操作" width="120">
              <template slot-scope="scope">
                <el-button
                    size="mini"
                    type="primary"
                    @click="handleDelete(scope.$index, scope.row)">关注
                </el-button>
              </template>
            </el-table-column>
          </el-table>
          <!--修改用户信息-->
          <el-form  v-if="menuIndex == '3-1'" :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" label-width="100px"
                   class="demo-ruleForm">
            <el-form-item label="用户名" prop="name">
              <el-input v-model="ruleForm2.name" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="年龄">
              <div class="block">
                <el-slider v-model="user.age"></el-slider>
              </div>
            </el-form-item>
            <el-form-item label="性别">
              <el-radio-group v-model="a" >
                <el-radio :label="0">男</el-radio>
                <el-radio :label="1">女</el-radio>
                <el-radio :label="2">外星人</el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="头像url">
              <el-input auto-complete="off" v-model="user.headImg"></el-input>
            </el-form-item>
            <el-form-item label="出生日期">
              <el-date-picker
                  v-model="user.birthday"
                  type="date"
                  placeholder="选择日期">
              </el-date-picker>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="register">提交</el-button>
              <el-button @click="resetForm('ruleForm2')">重置</el-button>
            </el-form-item>
          </el-form>
          <!--修改密码-->
          <el-form v-if="menuIndex == '3-2'" :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
            <el-form-item label="旧密码" prop="oldPass">
              <el-input v-model.number="ruleForm2.oldPass"></el-input>
            </el-form-item>
            <el-form-item label="新密码" prop="pass">
              <el-input type="password" v-model="ruleForm2.pass" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkPass">
              <el-input type="password" v-model="ruleForm2.checkPass" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submitForm('ruleForm2')">提交</el-button>
              <el-button @click="resetForm('ruleForm2')">重置</el-button>
            </el-form-item>
          </el-form>

        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "LeftUserPanel",
  data() {
    var checkUserName = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入用户名'));
      } else {
        axios.get("http://localhost:8080/user/findUserName/" + this.ruleForm2.name).then(response => {
              if (response.data === "error") {
                callback(new Error('该用户名已存在'));
              } else {
                console.log(this.user.gender)
                callback()
                this.user.username = this.ruleForm2.name
              }
            }
        )
      }
    }

    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.ruleForm2.checkPass !== '') {
          this.$refs.ruleForm2.validateField('checkPass');
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.ruleForm2.pass) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };
    return {
      user: {
        id: '',
        username: '',
        password: '',
        age: '',
        gender: '1',
        birthday: '',
        headImg: '',
      },
      ruleForm2: {
        pass: '',
        checkPass: '',
        name: '',
        oldPass: '',
      },
      rules2: {
        name: [
          {validator: checkUserName, trigger: 'blur'}
        ],
        pass: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur' }
        ],
      },
      tableData: [{
        id: "1",
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        id: "2",
        date: '2016-05-04',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1517 弄'
      }, {
        id: "3",
        date: '2016-05-01',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1519 弄'
      }, {
        id: "4",
        date: '2016-05-03',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1516 弄'
      }],
      users: [
        {
          headImg: 'https://c-ssl.duitang.com/uploads/item/202004/02/20200402141719_skisu.jpg',
          name: '张三',
          introduction: '这是张三',
          sex: 'male',
        },
        {
          headImg: 'https://c-ssl.duitang.com/uploads/item/202004/02/20200402141719_skisu.jpg',
          name: '李四',
          introduction: '这是李四',
          sex: 'male',
        },
        {
          headImg: 'https://c-ssl.duitang.com/uploads/item/202004/02/20200402141719_skisu.jpg',
          name: '王五',
          introduction: '这是王五',
          sex: 'female',
        },
        {
          headImg: 'https://c-ssl.duitang.com/uploads/item/202004/02/20200402141719_skisu.jpg',
          name: '赵六',
          introduction: '这是赵六',
          sex: 'female',
        },
      ],
      menuIndex: '1-1',
    }
  },
  methods: {
    formatter(row, column) {
      return row.address;
    },
    handleDelete(index, row) {
      console.log(index);
      console.log(row)
    },
    handleSelect(index) {
      this.menuIndex = index
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!');
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
  }
}
</script>

<style scoped>
.main-font {
  margin-left: 10%;
  margin-right: 10%;
  width: 80%;
}

.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.round-icon {
  width: 34px;
  height: 34px;
  display: flex;
  border-radius: 50%;
  align-items: center;
  justify-content: center;
  overflow: hidden;
}
</style>