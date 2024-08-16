"use strict";
const common_vendor = require("../../../../common/vendor.js");
const _sfc_main = {
  data() {
    return {
      formData: {
        email: "",
        phone: ""
      },
      rules: {
        email: {
          rules: [
            {
              required: true,
              errorMessage: "email and phone need input at least one"
            },
            {
              validateFunction: function(rule, value, data, callback) {
                console.log(rule, value, data, callback);
                if (data.email != "" || data.phone != "") {
                  return true;
                } else {
                  callback("input at least one");
                }
              }
            }
          ]
        },
        phone: {
          rules: [{
            required: true,
            errorMessage: "email and phone need input at least one"
          }, {
            validateFunction: function(rule, value, data, callback) {
              console.log(rule, value, data, callback);
              if (data.email != "" || data.phone != "") {
                return true;
              } else {
                callback("input at least one");
              }
            }
          }]
        }
      }
    };
  },
  onReady() {
    this.$refs.form.setRules(this.rules);
  },
  methods: {
    submit(form) {
      if (this.formData.email != "") {
        this.rules.phone.rules[0].required = false;
      }
      this.$refs.form.validate().then((res) => {
        console.log("表单数据信息：", res);
      }).catch((err) => {
        console.log("表单错误信息：", err);
      });
    }
  }
};
if (!Array) {
  const _easycom_uni_easyinput2 = common_vendor.resolveComponent("uni-easyinput");
  const _easycom_uni_forms_item2 = common_vendor.resolveComponent("uni-forms-item");
  const _easycom_uni_forms2 = common_vendor.resolveComponent("uni-forms");
  (_easycom_uni_easyinput2 + _easycom_uni_forms_item2 + _easycom_uni_forms2)();
}
const _easycom_uni_easyinput = () => "../../../../uni_modules/uni-easyinput/components/uni-easyinput/uni-easyinput.js";
const _easycom_uni_forms_item = () => "../../../../uni_modules/uni-forms/components/uni-forms-item/uni-forms-item.js";
const _easycom_uni_forms = () => "../../../../uni_modules/uni-forms/components/uni-forms/uni-forms.js";
if (!Math) {
  (_easycom_uni_easyinput + _easycom_uni_forms_item + _easycom_uni_forms)();
}
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  return {
    a: common_vendor.o(($event) => $data.formData.email = $event),
    b: common_vendor.p({
      placeholder: "",
      modelValue: $data.formData.email
    }),
    c: common_vendor.p({
      label: "email",
      name: "email"
    }),
    d: common_vendor.o(($event) => $data.formData.phone = $event),
    e: common_vendor.p({
      placeholder: "",
      modelValue: $data.formData.phone
    }),
    f: common_vendor.p({
      label: "phone",
      name: "phone"
    }),
    g: common_vendor.sr("form", "1b2feffa-0"),
    h: common_vendor.p({
      modelValue: $data.formData
    }),
    i: common_vendor.o((...args) => $options.submit && $options.submit(...args))
  };
}
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["render", _sfc_render]]);
wx.createPage(MiniProgramPage);
