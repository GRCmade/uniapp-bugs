/**
 * 复制数组
 * @param {*} data 
 * @param {*} count 
 */
function createCopies(data, count) {
    return Array.from({ length: count }, () => JSON.parse(JSON.stringify(data)));
}

// 首页优惠券数据
export const mock_couponInfo = [
    {
        couponAmount: '1.00',
        couponType: 1,
        extra: '满100元可用',
        sort: 1,
        type: 'plat',
        meetPrice: null
    },
    ...createCopies({
        couponAmount: '1.00',
        couponType: 1,
        extra: '满100元可用',
        sort: 1,
        type: 'plat',
        meetPrice: null
    }, 2)
]