import axios from 'axios';
import { Message } from 'element-ui';
import router from "./router/index.js";


function errorMssage(){
	Message({
				message: '网络服务器错误',
			    type: 'error',
			    duration: 3 * 1000
	})
}

function checkCode (res) {
  if (res.data.code === 400) {
	  Message({
			message: '登陆失效请重新登陆',
		    type: 'error',
		    duration: 3 * 1000
	  })
	  router.push({path: "/login"});
      return res.data;
  }else if(res.data.code === 401){
	  Message({
	  			message: '无 操作/查 看权限',
	  		    type: 'error',
	  		    duration: 3 * 1000
	  })
  }
  else if(res.data.code === 200){
	  if(res.data.extend.msg){
		  Message({
		  			message: res.data.extend.msg,
		  		    type: 'error',
		  		    duration: 3 * 1000
		  })
	  }
  }
  return res.data;
}

export default {
    post (url, data) {
        return axios({
            method: 'post',
            baseURL: '/api',
            url,
	        data: JSON.stringify(data),
            timeout: 10000,
            headers: {
              'Content-Type': 'application/json;charset=UTF-8'
            },
	    }).then(
	    	 (res) => {
				 console.log(res.data)
	    	   return checkCode(res)
	    	 }
	    ).catch(
	    	 (error) => {
				if(url === 'logout'){
					return;
				}
				errorMssage();
	    	    return '出错'
	    	 }
	    )
    },
	get (url, data) {
	    return axios({
	        method: 'get',
	        baseURL: '/api',
	        url,
	        data: JSON.stringify(data),
	        timeout: 10000,
	        headers: {
	          'Content-Type': 'application/json;charset=UTF-8'
	        },
	    }).then(
	    	 (res) => {
	    	   console.log(res)
	    	   return checkCode(res)
	    	 }
	    ).catch(
	    	 (error) => {
				errorMssage();
	    	    return '出错'
	    	 }
	    )
	},
	upload (url, data) {
	    return axios({
	        method: 'post',
	        baseURL: '/api',
	        url,
			data:data,
	        timeout: 10000,
	        headers: {
	          'Content-Type': 'multipart/form-data'
	        }
	    }).then(
	    	 (res) => {
	    	   console.log(res)
	    	   return res
	    	 }
	    ).catch(
	    	 (error) => {
				errorMssage();
	    	    return '出错'
	    	 }
	    )
	}

}