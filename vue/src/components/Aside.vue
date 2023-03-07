<template>
  <el-menu :default-openeds="['1', '3']" style="height: 100%;overflow-x: hidden "
           background-color="rgb(48,65,86)"
           text-color="#fff"
           active-text-color="#ffd04b"
           :collapse-transition="false"
           :collapse="isCollapse"
           router
  >

    <div style="height: 60px;line-height: 60px;text-align: center">
      <img src="../assets/logo.png" alt="" style="width:20px;position: relative;top:5px;margin-right: 5px">
      <b style="color: white" v-show="logoTextShow">中草药病虫害识别管理系统</b>
    </div>

<!--    <el-submenu index="1">-->
<!--      <template slot="title"><i class="el-icon-message"></i>-->
<!--        <span slot="title">导航一</span>-->
<!--      </template>-->
<!--      <el-menu-item-group>-->
<!--        <template slot="title">分组一</template>-->
<!--        <el-menu-item index="1-1">选项1</el-menu-item>-->
<!--        <el-menu-item index="1-2">选项2</el-menu-item>-->
<!--      </el-menu-item-group>-->
<!--      <el-menu-item-group title="分组2">-->
        <el-menu-item index="/">

          <template slot="title"><i class="el-icon-house"></i>
            <span slot="title">主页</span>
          </template>
        </el-menu-item>
<!--      </el-menu-item-group>-->
<!--      <el-submenu index="1-4">-->
<!--        <template slot="title">选项4</template>-->
<!--        <el-menu-item index="1-4-1">选项4-1</el-menu-item>-->
<!--      </el-submenu>-->
<!--    </el-submenu>-->
    <el-submenu index="2">
      <template slot="title"><i class="el-icon-menu"></i>
        <span slot="title">系统管理</span>
      </template>
      <el-menu-item-group>
<!--        <template slot="title">分组一</template>-->
        <el-menu-item index="/user">
          <template slot="title"><i class="el-icon-s-custom"></i>
            <span slot="title">用户管理</span>
          </template>
        </el-menu-item>
          <el-menu-item index="/mainframe">
              <template slot="title"><i class="el-icon-s-custom"></i>
                  <span slot="title">病虫害专家信息库</span>
              </template>
          </el-menu-item>


        <el-menu-item index="2-2">部门管理</el-menu-item>
      </el-menu-item-group>
<!--      <el-menu-item-group title="分组2">-->
<!--        <el-menu-item index="2-3">选项3</el-menu-item>-->
<!--      </el-menu-item-group>-->
<!--      <el-submenu index="2-4">-->
<!--        <template slot="title">选项4</template>-->
<!--        <el-menu-item index="2-4-1">选项4-1</el-menu-item>-->
<!--      </el-submenu>-->
    </el-submenu>
    <el-submenu index="3">
      <template slot="title">
        <span slot="title">病虫害模块信息管理</span>
      </template>

      <el-menu-item-group>
<!--       这里写/controller 还是直接controller都可以-->
        <el-menu-item index="/controller">
        <template slot="title">
          <span slot="title">环境信息模块</span>
        </template>
        </el-menu-item>



        <el-menu-item index="/water">
          <template slot="title">
            <span slot="title">病虫害识别模块</span>
          </template>
        </el-menu-item>

<!--        <el-menu-item index="/environment">-->
<!--          <template slot="title">-->
<!--            <span slot="title">环保模块</span>-->
<!--          </template>-->
<!--        </el-menu-item>-->

<!--        <el-menu-item index="/smoke">-->
<!--          <template slot="title">-->
<!--            <span slot="title">烟风系统模块</span>-->
<!--          </template>-->
<!--        </el-menu-item>-->

<!--        <el-menu-item index="/deslagging">-->
<!--          <template slot="title">-->
<!--            <span slot="title">除渣系统模块</span>-->
<!--          </template>-->
<!--        </el-menu-item>-->

<!--        <el-menu-item index="/energy">-->
<!--          <template slot="title">-->
<!--            <span slot="title">节能系统模块</span>-->
<!--          </template>-->
<!--        </el-menu-item>-->

        <el-menu-item index="/feeding">
          <template slot="title">
            <span slot="title">病虫害报警系统模块</span>
          </template>
        </el-menu-item>
      </el-menu-item-group>
    </el-submenu>


<!--    <el-submenu index="3">-->
<!--      <template slot="title"><i class="el-icon-setting"></i>-->
<!--        <span slot="title">导航三</span>-->
<!--      </template>-->
<!--      <el-menu-item-group>-->
<!--        <template slot="title">分组一</template>-->
<!--        <el-menu-item index="3-1">选项1</el-menu-item>-->
<!--        <el-menu-item index="3-2">选项2</el-menu-item>-->
<!--      </el-menu-item-group>-->
<!--      <el-menu-item-group title="分组2">-->
<!--        <el-menu-item index="3-3">选项3</el-menu-item>-->
<!--      </el-menu-item-group>-->
<!--      <el-submenu index="3-4">-->
<!--        <template slot="title">选项4</template>-->
<!--        <el-menu-item index="3-4-1">选项4-1</el-menu-item>-->
<!--      </el-submenu>-->
<!--    </el-submenu>-->
  </el-menu>
</template>

<script>
export default {
  name: "Aside.vue",
  props:{
    isCollapse: Boolean,
    logoTextShow: Boolean
  }
}
</script>

<style scoped>

</style>