export  function handleDataOne(form, dom) {
	if(!form.address) {
	    dom.show({ message: "请选择房屋地址" })
	    return false
	}
	if(!form.detailAdress && form.houseType == '自建房') {
	     dom.show({ message: "请输入详细地址" })
	    return false
	}
	if(!form.communityName && form.houseType == '自建房') {
	     dom.show({ message: "请选择社区" })
	    return false
	}
	if(!form.groupName && form.houseType == '自建房') {
	     dom.show({ message: "请输入村组" })
	    return false
	}
	if(!form.houseStatus) {
	     dom.show({ message: "请选择房屋状态" })
	    return false
	}
	if(!form.gridName) {
	    dom.show({ message: "请选择网格" })
	    return false
	}
	if(!uni.$u.trim(form.owner)) {
	    dom.show({ message: "请输入户主" })
	    return false
	}
	if(form.idNumber && !uni.$u.test.idCard(form.idNumber)) {
	     dom.show({ message: "请输入正确身份证号" })
	    return false
	}
	if(!form.phone) {
	     dom.show({ message: "请输入联系方式" })
	    return false
	} else {
	    if(!uni.$u.test.mobile(form.phone)) {
	        dom.show({ message: "请输入正确联系方式" })
	        return false
	    }
	}
	return true
}

export function handleDataTwo(form, dom, type) {
	if(!uni.$u.trim(form.name)) {
	    dom.show({ message: "请输入居住人姓名" })
	    return false
	}
	if(!form.phone) {
	    dom.show({ message: "请输入手机号码" })
	    return false
	} else {
	    if(!uni.$u.test.mobile(form.phone)) {
	        dom.show({ message: "请输入正确手机号码" })
	        return false
	    }
	}
	if(!form.idNumber) {
	    dom.show({ message: "请输入身份证号码" })
	    return false
	} else {
	    if(!uni.$u.test.idCard(form.idNumber)) {
	        dom.show({ message: "请输入正确身份证号码" })
	        return false
	    }
	}
	if(!form.relationshipWithHouseholder && type == 'addHousehold') {
	    dom.show({ message: "请选择与户主的关系" })
	    return false
	}
	if(!form.householdType) {
	    dom.show({ message: "请选择户籍人口" })
	    return false
	}
	if(!form.residentType) {
	    dom.show({ message: "请选择实有人口" })
	    return false
	}
	return true
}