import { logout } from '@/redux/userSlice';
import React from 'react';
import { useDispatch, useSelector } from 'react-redux';

function ProfileMenu() {
  const dispatch = useDispatch();
  const { nickname, email } = useSelector((state) => state.user);

  const convertNickName = () => {
    if (nickname.length <= 1) {
      return nickname;
    }

    const check = /[a-zA-Z]/;

    if (check.test(nickname)) {
      return nickname[0] + nickname[1];
    }

    return nickname[0];
  };
  const onClickLogout = () => {
    dispatch(logout());
  };

  return (
    <div className="absolute py-4 top-16 right-7 bg-background w-[370px] rounded-small shadow-lg z-50">
      <div className="mb-4 text-center">{email}</div>
      <div className="flex items-center justify-center mb-4">
        <div
          className="flex items-center justify-center w-16 h-16 text-xl font-bold text-white rounded-full"
          style={{
            background: '#8D6E63',
          }}
        >
          <span
            className="text-3xl"
            style={{
              position: 'relative',
              bottom: '0.2em',
            }}
          >
            {convertNickName()}
          </span>
        </div>
      </div>
      <div className="mb-4">
        <div className="text-lg text-center">안녕하세요. {nickname}님</div>
      </div>
      <div>
        <button className="w-full p-2 hover:bg-outline">닉네임 변경</button>
        <button className="w-full p-2 hover:bg-outline">마이 레포트</button>
        <button className="w-full p-2 hover:bg-outline" onClick={onClickLogout}>
          로그아웃
        </button>
      </div>
    </div>
  );
}

export default ProfileMenu;
