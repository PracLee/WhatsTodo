/*!
 * classie - class helper functions
 * from bonzo https://github.com/ded/bonzo
 * 
 * classie.has( elem, 'my-class' ) -> true/false
 * classie.add( elem, 'my-new-class' )
 * classie.remove( elem, 'my-unwanted-class' )
 * classie.toggle( elem, 'my-class' )
 */

/*jshint browser: true, strict: true, undef: true */
/*global define: false */

( function( window ) {

'use strict';

// class helper functions from bonzo https://github.com/ded/bonzo

function classReg( className ) {
  return new RegExp("(^|\\s+)" + className + "(\\s+|$)");
}

// classList support for class management
// altho to be fair, the api sucks because it won't accept multiple classes at once
var hasClass, addClass, removeClass;

if ( 'classList' in document.documentElement ) {
  hasClass = function( elem, c ) {
    return elem.classList.contains( c );
  };
  addClass = function( elem, c ) {
    elem.classList.add( c );
  };
  removeClass = function( elem, c ) {
    elem.classList.remove( c );
  };
}
else {
  hasClass = function( elem, c ) {
    return classReg( c ).test( elem.className );
  };
  addClass = function( elem, c ) {
    if ( !hasClass( elem, c ) ) {
      elem.className = elem.className + ' ' + c;
    }
  };
  removeClass = function( elem, c ) {
    elem.className = elem.className.replace( classReg( c ), ' ' );
  };
}

function toggleClass( elem, c ) {
  var fn = hasClass( elem, c ) ? removeClass : addClass;
  fn( elem, c );
}

var classie = {
  // full names
  hasClass: hasClass,
  addClass: addClass,
  removeClass: removeClass,
  toggleClass: toggleClass,
  // short names
  has: hasClass,
  add: addClass,
  remove: removeClass,
  toggle: toggleClass
};

// transport
if ( typeof define === 'function' && define.amd ) {
  // AMD
  define( classie );
} else {
  // browser global
  window.classie = classie;
}

})( window );

// Custom JS
function showInput(index){
	$("#input_"+index).removeClass();
	$("#updateButton_"+index).removeClass();
	$("#text_"+index).css('display','none');
	$("#text_"+index).css('visibility','hidden');
	$("#showInputButton_"+index).css('display','none');
	$("#showInputButton_"+index).css('visibility','hidden');
}

function todoEditDB(index){ 
	var msg = $("#input_"+index).val().replaceAll("??", "⁇").replaceAll("&","＆").replaceAll("%","％")
	.replaceAll("+","＋").replaceAll("\\", "￦");
	var params = "todo="+$("#input_"+index).val()+"&todoNum="+index;

	$.ajax({
		type:"post",
		url:"updateTodo.do",
		data:params,
		dataType:"json",
		success:function(args){
			// console.log("성공했으면 소리질러!!");
			$('#text_'+index).css('display','');
			$('#text_'+index).css('visibility','');
			$('#showInputButton_'+index).css('display','');
			$('#showInputButton_'+index).css('visibility','');
			$('#input_'+index).css('display','none');
			$('#input_'+index).css('visibility','hidden');
			$('#updateButton_'+index).css('display','none');
			$('#updateButton_'+index).css('visibility','hidden');

			$("#text_"+index).text(args);
		}
	})
}
