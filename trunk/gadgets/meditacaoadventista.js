$('meditacao_day').value = new Date().getDate();
$('meditacao_month').value = new Date().getMonth() + 1;
$('meditacao_year').value = new Date().getFullYear();
var meditacao = {
  show: function() {
    $('meditacao_loader').style.visibility = 'visible';
    $('meditacao_show').style.visibility = 'visible';
    var day = $('meditacao_day').value;
    if (parseInt(day) < 10) {
      day = "0" + day;
    }
    var month = $('meditacao_month').value;
    if (parseInt(month) < 10) {
      month = "0" + month;
    }
alert('http://meditacaoadventistamobile.googlecode.com/svn/trunk/fs/' + $('meditacao_edition').value + '/' + $('meditacao_year').value + '/' + $('meditacao_year').value + month + day + '.txt');
    new Ajax.Request('http://meditacaoadventistamobile.googlecode.com/svn/trunk/fs/' + $('meditacao_edition').value + '/' + $('meditacao_year').value + '/' + $('meditacao_year').value + month + day + '.txt', {
      onSuccess: function(result) {
        alert(result);
        alert(result.responseText);
      }
    });
  }
};
