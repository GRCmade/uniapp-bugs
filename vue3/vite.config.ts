import { defineConfig, loadEnv } from 'vite'
import uni from '@dcloudio/vite-plugin-uni'

// https://vitejs.dev/config/
export default defineConfig(({ mode }) => {
  const env = loadEnv(mode, process.cwd(), '')
  return {
    plugins: [uni()],
    resolve: {
      extensions: ['.mjs', '.js', '.ts', '.jsx', '.tsx', '.json', '.vue', '.scss']
    },
    css: {
      preprocessorOptions: {
        scss: {
          additionalData: `
          $env: "${env.VITE_APP_ENV}";
        `
        }
      }
    }
  }
})
