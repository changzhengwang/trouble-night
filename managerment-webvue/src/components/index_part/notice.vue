<template>
		<div style="width: 100%; background-color: #ffaa00;text-align: center;">
		  <h3>广播{{nowOne+1}}：{{nowNotice}}</h3>
		</div>
</template>

<script>
  export default {
    data() {
      return {
        timer: '',
        sum: 4,
		nowOne:0,
		nowNotice:'',
		notices:["111111111111111条记录","222222222222条记录","33333333333333333333条记录","444444444444444444条记录"]
      };
    },
    methods: {
      get() {
		if(this.nowOne<this.notices.length-1){
			this.nowOne++;
			this.nowNotice=this.notices[this.nowOne];
		}else{
			this.nowOne=0;
			this.nowNotice=this.notices[0];
		}
      }
    },
	created(){
		this.nowNotice=this.notices[0];
	},
    mounted() {
      this.timer = setInterval(this.get, 3000);
    },
    beforeDestroy() {
      clearInterval(this.timer);
    }
  };
</script>

<style>
	
</style>