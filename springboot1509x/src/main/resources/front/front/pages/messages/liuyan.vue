<template>
<view class="content">
	<view :style='{"width":"100%","padding":"0 0 144rpx 0","position":"relative","background":"url(http://codegen.caihongy.cn/20221018/6b04e4b2331b4f3d85b1103feff37414.jpg)","height":"100vh"}'>
		<form :style='{"width":"100%","padding":"24rpx","background":"none","display":"block","height":"auto"}'>
			<view :style='{"padding":"4rpx 16rpx","margin":"0 0 8rpx 0","borderColor":"#e8e8e8","alignItems":"center","borderRadius":"16rpx","borderWidth":"0 0 2rpx 0","background":"-webkit-linear-gradient(top,#eee,#fff)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#999","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' disabled="true" v-model="ruleForm.username" placeholder="留言人用户名"></input>
			</view>
			<view :style='{"padding":"4rpx 16rpx","margin":"0 0 8rpx 0","borderColor":"#e8e8e8","alignItems":"center","borderRadius":"16rpx","borderWidth":"0 0 2rpx 0","background":"-webkit-linear-gradient(top,#eee,#fff)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
				<textarea :style='{"border":"0","minHeight":"240rpx","padding":"24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx"}' v-model="ruleForm.content" placeholder="留言内容"></textarea>
			</view>
			<view @tap="uploadTap" :style='{"padding":"4rpx 16rpx","margin":"0 0 8rpx 0","borderColor":"#e8e8e8","alignItems":"center","borderRadius":"16rpx","borderWidth":"0 0 2rpx 0","background":"-webkit-linear-gradient(top,#eee,#fff)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.cpicture" :src="baseUrl+ruleForm.cpicture" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"width":"100%","justifyContent":"center","display":"flex","height":"auto"}'>
				<button :style='{"border":"2rpx solid #ffaa33","padding":"0px","boxShadow":"2rpx 4rpx 8rpx #a86b15,inset 0px 0px 112rpx 0px #ffaa33","margin":"32rpx 0 0 0","color":"rgb(255, 255, 255)","borderRadius":"16rpx","background":"#ffe6c3","width":"30%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red margin-tb-sm">提交</button>
			</view>
		</form>
	</view>
</view>
</template>

<script>
	export default {
		data() {
			return {
				ruleForm: {
					userid: '',
					username: '',
					content: '',
					reply: '',
					cpicture: '',
				},
				user: {}
			}
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
		async onLoad(options) {
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			// 如果有登陆，获取登陆后保存的userid
			this.ruleForm.userid = uni.getStorageSync("userid")
            if(table == `yonghu`){
                this.ruleForm.username = this.user.yonghuzhanghao
            }
			this.styleChange()
		},
		methods: {
			uploadTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.cpicture = 'upload/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(()=>{
						_this.styleChange()
					})
				});
			},
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.my-publish-pv .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.myPublishForm.content.input.backgroundColor
					// })
				})
			},
			async onSubmitTap() {
				if(this.ruleForm.content){
                    this.ruleForm.avatarurl = uni.getStorageSync('headportrait')?uni.getStorageSync('headportrait'):'';
                    var sensitiveWords = "";
                    var sensitiveWordsArr = [];
                    if(sensitiveWords) {
                        sensitiveWordsArr = sensitiveWords.split(",");
                    }
                    for(var i=0; i<sensitiveWordsArr.length; i++){
                        //全局替换
                        var reg = new RegExp(sensitiveWordsArr[i],"g");
                        //判断内容中是否包括敏感词
                        if (this.ruleForm.content.indexOf(sensitiveWordsArr[i]) > -1) {
                            // 将敏感词替换为 **
                            this.ruleForm.content = this.ruleForm.content.replace(reg,"**");
                        }
                    }
					await this.$api.add(`messages`, this.ruleForm);
					this.$utils.msgBack('提交成功');
				}else{
					this.$utils.msg("请填写留言内容")
				}
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
