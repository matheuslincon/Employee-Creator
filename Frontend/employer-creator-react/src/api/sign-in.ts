import { api } from '@/lib/axios'

export interface SignInBody {
  username: string
  password: string
}

export interface SignInResponse {
  accessToken: string
}

export const signIn = async ({
  username,
  password,
}: SignInBody): Promise<SignInResponse> => {
  const response = await api.post('/auth/signin', {
    username,
    password,
  })

  return response.data
}
