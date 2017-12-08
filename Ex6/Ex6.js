let str = "milab";
for (let i = 0; i < str.length; i++) {
	console.log(str);
	str = str.charAt(str.length - 1).concat("", str.substring(0, str.length - 1));
}