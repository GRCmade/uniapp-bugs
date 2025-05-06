module.exports = {
  root: true,
  env: {
    browser: true,
    node: true,
    es2021: true
  },
  extends: [
    'plugin:vue/vue3-recommended',
    'eslint:recommended',
    '@vue/typescript/recommended',
    'plugin:prettier/recommended'
  ],
  parserOptions: {
    ecmaVersion: 2021,
    parser: '@typescript-eslint/parser'
  },
  rules: {
    'no-console': process.env.NODE_ENV === 'production' ? 'warn' : 'off',
    'no-debugger': process.env.NODE_ENV === 'production' ? 'warn' : 'off',
    '@typescript-eslint/explicit-module-boundary-types': 'off',
    '@typescript-eslint/no-explicit-any': 'off',
    'vue/multi-word-component-names': 'off',
    'vue/require-default-prop': 'off',
    'vue/script-setup-uses-vars': 'error',
    '@typescript-eslint/no-empty-function': 'off',
    'no-empty-function': 'off',
    'prettier/prettier': [
      'error',
      {
        vueIndentScriptAndStyle: false
      }
    ],
    'vue/html-indent': ['error', 2],
    'vue/script-indent': ['error', 2, { baseIndent: 0 }]
  },
  globals: {
    uni: true,
    wx: true,
    plus: true,
    getCurrentPages: true
  },
  overrides: [
    {
      files: ['*.vue'],
      rules: {
        indent: 'off'
      }
    }
  ]
}
