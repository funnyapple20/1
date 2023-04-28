import requests
import json

while(True):
  headers = {
      "Content-Type": "application/json",
      "Authorization": "Bearer sk
-INbYn7cEB
SnU0vydXrRKT3BlbkFJ
WzTi4Hph3EkmbPtIZKTl "
  }

  data = {
      "prompt": " ",
      "max_tokens": 4000,
      "model": "text-davinci-003"
  }
  prompt1 = input("Enter your prompt")
  data["prompt"] = prompt1

  response = requests.post("https://api.openai.com/v1/completions", headers=headers, data=json.dumps(data))
  response_data = response.json()

  generated_text = response_data["choices"][0]["text"]
  print(generated_text)
