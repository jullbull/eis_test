<template>
  <div id="app">
    <component :is="viewContainer" :listOfCurrency ="currency" @listOfCurrency="currency=$event">
    </component>

    <component :is="selectComponent" :listOfCurrency ="currency" :show="show" >

    </component>
<!--{{currency.length}}-->

  </div>
</template>

<script>
  import ViewContainer from './components/ViewContainer';
  import appCurrencyTable from './components/CurrencyTable';

  export default {
    name: 'App',
    components: {
      viewContainer: ViewContainer,
      appCurrencyTable,



    },
    data() {
      return {
        currency:[],
        selectComponent: 'appCurrencyTable',
        viewContainer:'viewContainer',
        show:false,
      }
    },
    methods: {}

  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-left: 30px;
    margin-top: 30px;
  }
</style>
