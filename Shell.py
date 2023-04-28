import requests
import json

headers = {
    "Content-Type": "application/json",
    "Authorization": "Bearer sk-a5WutS5Zgr5
noG7EoF6jT3BlbkFJ0FwvS3SME
W0cSp3oRlYR"
}

data = {
    "prompt": "write a code in python to make a pie chart of given input of programming languages with their popularity and have section with distinct color and also make one section pop out",
    "max_tokens": 1000,
    "model": "text-davinci-003"
}
data["prompt"] = input("enter prompt")
response = requests.post("https://api.openai.com/v1/completions", headers=headers, data=json.dumps(data))
response_data = response.json()

generated_text = response_data["choices"][0]["text"]
print(generated_text)
