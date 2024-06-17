import requests
import json
import time
import pandas as pd

# 替换为你的百度地图API密钥
API_KEY = 'ryrbYdPGcgZQLQ2oClr0IbCGAyLdeTLZ'
# 搜索关键字
QUERY = '会计事务所'
# 地点检索API
PLACE_SEARCH_URL = 'http://api.map.baidu.com/place/v2/search'

def get_places(query, region, page_num, page_size=20):
    params = {
        'query': query,
        'region': region,
        'output': 'json',
        'ak': API_KEY,
        'page_num': page_num,
        'page_size': page_size
    }
    response = requests.get(PLACE_SEARCH_URL, params=params)
    if response.status_code == 200:
        return response.json()
    else:
        return None

def extract_info(places):
    place_list = []
    if 'results' in places:
        for place in places['results']:
            name = place.get('name')
            address = place.get('address')
            location = place.get('location')
            lat = location.get('lat')
            lng = location.get('lng')
            detail_info = place.get('detail_info', {})
            est_year = detail_info.get('establishment_date')  # 这个字段可能需要调整，根据实际API返回

            place_info = {
                'name': name,
                'address': address,
                'latitude': lat,
                'longitude': lng,
                'establishment_year': est_year
            }
            place_list.append(place_info)
    return place_list

def main():
    regions = ['北京', '上海', '广州', '深圳']  # 你可以扩展到全国范围的城市列表
    all_places = []

    for region in regions:
        page_num = 0
        while True:
            places = get_places(QUERY, region, page_num)
            if places and 'results' in places and len(places['results']) > 0:
                place_list = extract_info(places)
                all_places.extend(place_list)
                page_num += 1
                time.sleep(1)  # 避免请求过于频繁被封禁
            else:
                break

    # 使用pandas将结果保存为Excel文件
    df = pd.DataFrame(all_places)
    df.to_excel('accounting_firms.xlsx', index=False)

    print(f"共抓取到 {len(all_places)} 个会计事务所信息")

if __name__ == '__main__':
    main()
