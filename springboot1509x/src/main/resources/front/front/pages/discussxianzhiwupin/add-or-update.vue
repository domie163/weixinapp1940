<template>
<view class="content">
	<view :style='{"width":"100%","padding":"0 0 144rpx 0","position":"relative","background":"url(http://codegen.caihongy.cn/20221018/6b04e4b2331b4f3d85b1103feff37414.jpg)","height":"100%"}'>
		<form :style='{"width":"100%","padding":"24rpx","background":"none","display":"block","height":"auto"}' class="app-update-pv">
			
			<!-- ${location} -->
 

			<view :style='{"padding":"4rpx 0","margin":"0 0 8rpx 0","borderColor":"#e8e8e8","alignItems":"center","borderRadius":"16rpx","borderWidth":"0 0 2rpx 0","background":"-webkit-linear-gradient(top,#eee,#fff)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">评论内容</view>
				<textarea :style='{"border":"0","minHeight":"240rpx","padding":"24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx"}' v-model="ruleForm.content" placeholder="评论内容"></textarea>
			</view>
			
			
			<view :style='{"width":"100%","margin":"32rpx 0 0 0","justifyContent":"center","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"2rpx solid #ffaa33","padding":"0px","boxShadow":"2rpx 4rpx 8rpx #a86b15,inset 0px 0px 112rpx 0px #ffaa33","margin":"0 5% 0 0","color":"rgb(255, 255, 255)","borderRadius":"16rpx","background":"#ffe6c3","width":"28%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
    import xiaEditor from '@/components/xia-editor/xia-editor';
	export default {
		data() {
			return {
				cross:'',
				ruleForm: {
				refid: '',
				userid: '',
				avatarurl: '',
				nickname: '',
				content: '',
				reply: '',
				},
				// 登陆用户信息
				user: {},
                ro:{
                   refid : false,
                   userid : false,
                   avatarurl : false,
                   nickname : false,
                   content : false,
                   reply : false,
                },
			}
		},
		components: {
			wPicker,
            xiaEditor
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},



		},
		async onLoad(options) {
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			



			// 如果有登陆，获取登陆后保存的userid
			this.ruleForm.userid = uni.getStorageSync("userid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = options.refid;
				this.ruleForm.nickname = uni.getStorageSync("nickname");
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`discussxianzhiwupin`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='refid'){
					this.ruleForm.refid = obj[o];
					this.ro.refid = true;
					continue;
					}
					if(o=='userid'){
					this.ruleForm.userid = obj[o];
					this.ro.userid = true;
					continue;
					}
					if(o=='avatarurl'){
					this.ruleForm.avatarurl = obj[o].split(",")[0];
					this.ro.avatarurl = true;
					continue;
					}
					if(o=='nickname'){
					this.ruleForm.nickname = obj[o];
					this.ro.nickname = true;
					continue;
					}
					if(o=='content'){
					this.ruleForm.content = obj[o];
					this.ro.content = true;
					continue;
					}
					if(o=='reply'){
					this.ruleForm.reply = obj[o];
					this.ro.reply = true;
					continue;
					}
				}
			}
			this.styleChange()
		},
		methods: {
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},

			// 多级联动参数




			avatarurlTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.avatarurl = 'upload/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(()=>{
						_this.styleChange()
					})
				});
			},

			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
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













//跨表计算判断
				var obj;
				if((!this.ruleForm.refid)){
					this.$utils.msg(`关联表id不能为空`);
					return
				}
				if((!this.ruleForm.userid)){
					this.$utils.msg(`用户id不能为空`);
					return
				}
				if((!this.ruleForm.content)){
					this.$utils.msg(`评论内容不能为空`);
					return
				}
				//更新跨表属性
			       var crossuserid;
			       var crossrefid;
			       var crossoptnum;
				if(this.cross){
					var statusColumnName = uni.getStorageSync('statusColumnName');
					var statusColumnValue = uni.getStorageSync('statusColumnValue');
					if(statusColumnName!='') {
                        if(!obj) {
						    obj = uni.getStorageSync('crossObj');
                        }
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}

							}
							var table = uni.getStorageSync('crossTable');
							await this.$api.update(`${table}`, obj);
						} else {
						       crossuserid=Number(uni.getStorageSync('userid'));
						       crossrefid=obj['id'];
						       crossoptnum=uni.getStorageSync('statusColumnName');
						       crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
				}
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid=crossuserid;
					this.ruleForm.crossrefid=crossrefid;
					let params = {
						page: 1,
						limit:10,
						crossuserid:crossuserid,
						crossrefid:crossrefid,
					}
					let res = await this.$api.list(`discussxianzhiwupin`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
						return false;
					} else {
                //跨表计算
						if(this.ruleForm.id){
							await this.$api.update(`discussxianzhiwupin`, this.ruleForm);
						}else{
							await this.$api.add(`discussxianzhiwupin`, this.ruleForm);
						}
						uni.setStorageSync('discussxianzhiwupinCleanType',true);
						this.$utils.msgBack('提交成功');
					}
				} else {
                //跨表计算
					if(this.ruleForm.id){
						await this.$api.update(`discussxianzhiwupin`, this.ruleForm);
					}else{
						await this.$api.add(`discussxianzhiwupin`, this.ruleForm);
					}
					uni.setStorageSync('discussxianzhiwupinCleanType',true);
					this.$utils.msgBack('提交成功');
				}
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				this.$refs[str].show();
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
