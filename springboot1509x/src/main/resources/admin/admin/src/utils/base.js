const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot1509x/",
            name: "springboot1509x",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot1509x/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于微信小程序的闲置品交易平台"
        } 
    }
}
export default base
