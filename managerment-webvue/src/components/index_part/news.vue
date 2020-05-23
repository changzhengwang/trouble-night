<template>
	<div>
		<h3>{{newstype}}</h3>
		<ul class="live">
		  <li>关于加强我校学生宿舍管理最新办法</li>
		  <li>This is most certainly cool, and it can also work on long texts inside the list-item elements, which spans over multiple lines</li>
		  <li>Un-ordered lists are fun to play with</li>
		  <li>Firefox sure does animate this effect nicely</li>
		  <li>This is so simple</li>
		</ul>
	</div>
	
</template>

<script>
	export default{
		props:{
			newstype:String
		},
		data(){
			return{
				newsList:Array
			}
		}
	}
</script>

<style scoped="">
	ul {
	  width: 92%;
	  display: inline-block;
	  text-align: left;
	  vertical-align: top;
	  background: rgba(0, 0, 0, 0.2);
	  color: rgba(255, 255, 255, 0.5);
	  border-radius: 5px;
	  padding: 1.5em;
	  box-shadow: 0 0 8px rgba(0, 0, 0, 0.2);
	}
	.live > li:hover {
	  color: #FFF;
	}
	.live > li:hover::before {
	  -webkit-transform: scale(2);
	      -ms-transform: scale(2);
	          transform: scale(2);
	  opacity: 1;
	  text-shadow: 0 0 4px;
	  -webkit-transition: .1s;
	          transition: .1s;
	}
</style>
