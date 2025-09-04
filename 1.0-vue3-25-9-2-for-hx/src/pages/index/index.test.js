
describe('index', () => {
	let page
	beforeAll(async () => {
		page = await program.currentPage()
		await page.waitFor('view')
		await page.waitFor(1000)
	})

	it('logo', async () => {
		const logo = await page.$('.logo')
		expect(logo).not.toBeNull()
		await page.setData({title: 'new title 123456'})
	})
})
